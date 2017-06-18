/*
 * This contains the mapping of SQL stored procedures to the web server.
 */
package main;

import java.sql.*;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Jerico Manapsal
 */
public final class Database {
    
    private final Connection connection;
    private CallableStatement statement;
    
    public Database(final String url, final String username, final String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }
    
    /*
     * AccountsResource Methods
     */
    //start
    public final ResponseStatus createCustomer(final ParamsCreateCustomer params) throws SQLException {
        statement = connection.prepareCall("CALL CreateCustomer(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, BCrypt.hashpw(strip(params.password, 60), BCrypt.gensalt(12)));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.type, 7));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus createManager(final ParamsAccountInfo params) throws SQLException {
        statement = connection.prepareCall("CALL CreateManager(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, BCrypt.hashpw(strip(params.password, 60), BCrypt.gensalt(12)));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus editCustomer(final ParamsAccountInfo params) throws SQLException {
        statement = connection.prepareCall("CALL EditCustomer(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, BCrypt.hashpw(strip(params.password, 60), BCrypt.gensalt(12)));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus editManager(final ParamsAccountInfo params) throws SQLException {
        statement = connection.prepareCall("CALL EditManager(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, BCrypt.hashpw(strip(params.password, 60), BCrypt.gensalt(12)));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus deleteCustomer(final ParamsDeleteAccount params) throws SQLException {
        statement = connection.prepareCall("CALL DeleteCustomer(?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus deleteManager(final ParamsDeleteAccount params) throws SQLException {
        statement = connection.prepareCall("CALL DeleteManager(?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseLogin login(final ParamsLogin params) throws SQLException {
        statement = connection.prepareCall("CALL LoginCheckHash(?);");
        statement.setString(1, strip(params.username, 60));
        ResultSet result1 = statement.executeQuery();
        ResponseLogin rl = new ResponseLogin();
        if (!checkError(result1)) {
            if (BCrypt.checkpw(strip(params.password, 60), result1.getString(1))) {
                statement = connection.prepareCall("CALL Login(?,?);");
                statement.setString(1, strip(params.username, 60));
                statement.setString(2, BCrypt.hashpw(strip(params.password, 60), BCrypt.gensalt(12)));
                ResultSet result2 = statement.executeQuery();
                result2.next();
                rl.session = result2.getString(1);
                rl.username = result2.getString(2);
                rl.name = result2.getString(3);
                return rl;
            }
        }
        rl.session = "";
        rl.username = "";
        rl.name = "";
        return rl;
    }
    
    public final ResponseStatus logout(final ParamsSession params) throws SQLException {
        statement = connection.prepareCall("CALL Logout(?);");
        statement.setString(1, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    //end
    
    
    /*
     * BranchResource Methods
     */
    //start
    public final ResponseStatus createBranch(final ParamsCreateBranch params) throws SQLException {
        statement = connection.prepareCall("CALL CreateBranch(?,?,?,?,?,?,?);");
        statement.setString(1, strip(params.brand, 30));
        statement.setString(2, strip(params.branch, 60));
        statement.setString(3, strip(params.category, 30));
        statement.setInt(4, params.manager);
        statement.setFloat(5, params.latitude);
        statement.setFloat(6, params.longitude);
        statement.setString(7, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus editBranch(final ParamsEditBranch params) throws SQLException {
        statement = connection.prepareCall("CALL EditBranch(?,?,?,?,?,?,?,?);");
        statement.setInt(1, params.id);
        statement.setString(2, strip(params.brand, 30));
        statement.setString(3, strip(params.branch, 60));
        statement.setString(4, strip(params.category, 30));
        statement.setInt(5, params.manager);
        statement.setFloat(6, params.latitude);
        statement.setFloat(7, params.longitude);
        statement.setString(8, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus deleteBranch(final ParamsIDSession params) throws SQLException {
        statement = connection.prepareCall("CALL DeleteBranch(?,?);");
        statement.setInt(1, params.id);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseID getBranch(final ParamsSession params) throws SQLException {
        statement = connection.prepareCall("CALL GetBranch(?);");
        statement.setString(1, strip(params.session, 64));
        ResultSet result = statement.executeQuery();
        result.next();
        ResponseID rid = new ResponseID();
        rid.id = result.getInt(1);
        return rid;
    }
    
    public final ResponseSearchBrandList searchBrand(final ParamsBrandSession params) throws SQLException {
        statement = connection.prepareCall("CALL SearchBrand(?,?);");
        statement.setString(1, strip(params.brand, 30));
        statement.setString(2, strip(params.session, 64));
        ResultSet result = statement.executeQuery();
        ResponseSearchBrandList rsbl = new ResponseSearchBrandList();
        ArrayList<ResponseSearchBrand> list = new ArrayList<>();
        while (result.next()) {
            ResponseSearchBrand rsb = new ResponseSearchBrand();
            rsb.id = result.getInt(1);
            rsb.counter = result.getString(2);
            rsb.brand = result.getString(3);
            rsb.branch = result.getString(4);
            rsb.category = result.getString(5);
            list.add(rsb);
        }
        rsbl.list = list;
        return rsbl;
    }
    //end
    
    
    /*
     * CounterResource Methods
     */
    //start
    public final ResponseStatus createCounter(final ParamsCreateCounter params) throws SQLException {
        statement = connection.prepareCall("CALL CreateCounter(?,?,?,?);");
        statement.setInt(1, params.branch);
        statement.setString(2, strip(params.counter, 30));
        statement.setString(3, strip(params.type, 7));
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus editCounter(final ParamsEditCounter params) throws SQLException {
        statement = connection.prepareCall("CALL EditCounter(?,?,?,?,?);");
        statement.setInt(1, params.id);
        statement.setInt(2, params.branch);
        statement.setString(3, strip(params.counter, 30));
        statement.setString(4, strip(params.type, 7));
        statement.setString(5, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus deleteCounter(final ParamsIDSession params) throws SQLException {
        statement = connection.prepareCall("CALL DeleteCounter(?,?);");
        statement.setInt(1, params.id);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final NowServingList getNowServing(final ParamsIDSession params) throws SQLException {
        statement = connection.prepareCall("CALL GetNowServing(?,?);");
        statement.setInt(1, params.id);
        statement.setString(2, strip(params.session, 64));
        ResultSet result = statement.executeQuery();
        NowServingList list = new NowServingList();
        ArrayList<NowServing> al = new ArrayList<>();
        while (result.next()) {
            try {
                result.findColumn("status");
                break;
            } catch (SQLException ex) {
                NowServing ns = new NowServing();
                ns.counter = result.getString(1);
                ns.serving = result.getInt(2);
                al.add(ns);
            }
        }
        list.nowServingList = al;
        return list;
    }
    
    public final ResponseCurrentQueue getCurrentQueue(final ParamsSession params) throws SQLException {
        statement = connection.prepareCall("CALL GetCurrentQueue(?);");
        statement.setString(1, strip(params.session, 64));
        ResultSet result = statement.executeQuery();
        ResponseCurrentQueue rcq = new ResponseCurrentQueue();
        if (result.next()) {
            rcq.branch = result.getString(1);
            rcq.number = result.getInt(2);
            rcq.serving = result.getInt(3);
            rcq.linesahead = result.getInt(4);
        }
        return rcq;
    }
    //end
    
    
    /*
     * CounterResource Methods
     */
    //start
    public final ResponseStatus joinQueue(final ParamsCounterSession params) throws SQLException {
        statement = connection.prepareCall("CALL JoinQueue(?,?);");
        statement.setInt(1, params.counter);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus joinQueueByBrand(final ParamsFindBranches params) throws SQLException {
        statement = connection.prepareCall("CALL FindBranchesFromBrand(?,?,?,?);");
        statement.setString(1, strip(params.brandcategory , 30));
        statement.setFloat(2, params.latitude);
        statement.setFloat(3, params.longitude);
        statement.setString(4, strip(params.session , 64));
        ResultSet result1 = statement.executeQuery();
        ArrayList<ResponseBranch> list1 = new ArrayList<>();
        while (result1.next()) {
            ResponseBranch rb = new ResponseBranch();
            rb.id = result1.getInt(1);
            rb.branch = result1.getString(2);
            rb.length = result1.getInt(3);
            rb.distance = result1.getDouble(4);
            list1.add(rb);
        }
        result1.close();
        statement.close();
        if (list1.size() < 1) {
            ResponseStatus rs = new ResponseStatus();
            rs.status = 1;
            rs.status_id = 0;
            rs.status_msg = "No result.";
            return rs;
        }
        //use rough estimation for demo puposes
        //use an 120 seconds for each person in counter
        //use 2kph as slow movement speed
        double counter = 120d, speed = 0.56d;
        //sort using generic sorting algorithm
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.size() - 1; j++) {
                double difficulty1 = counter * list1.get(j).length + speed * list1.get(j).distance;
                double difficulty2 = counter * list1.get(j + 1).length + speed * list1.get(j + 1).distance;
                if (difficulty2 < difficulty1) {
                    ResponseBranch rb = new ResponseBranch();
                    rb.id = list1.get(j).id;
                    rb.branch = list1.get(j).branch;
                    rb.length = list1.get(j).length;
                    rb.distance = list1.get(j).distance;
                    list1.set(j, list1.get(j + 1));
                    list1.set(j + 1, rb);
                }
            }
        }
        
        statement = connection.prepareCall("CALL GetCounters(?,?);");
        statement.setInt(1, list1.get(0).id);
        statement.setString(2, strip(params.session , 64));
        ResultSet result2 = statement.executeQuery();
        ResponseCounter rc = new ResponseCounter();
        if (result2.next()) {
            rc.id = result2.getInt(1);
            rc.counter = result2.getString(2);
            rc.length = result2.getInt(3);
        }
        result2.close();
        statement.close();
        statement = connection.prepareCall("CALL JoinQueue(?,?);");
        statement.setInt(1, rc.id);
        statement.setString(2, strip(params.session , 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus joinQueueByCategory(final ParamsFindBranches params) throws SQLException {
        return null;
    }
    
    public final ResponseStatus leaveQueue(final ParamsCounterSession params) throws SQLException {
        statement = connection.prepareCall("CALL LeaveQueue(?,?);");
        statement.setInt(1, params.counter);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus serveComplete(final ParamsCounterSession params) throws SQLException {
        statement = connection.prepareCall("CALL ServeComplete(?,?);");
        statement.setInt(1, params.counter);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus serveNext(final ParamsCounterSession params) throws SQLException {
        statement = connection.prepareCall("CALL ServeNext(?,?);");
        statement.setInt(1, params.counter);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    //end
    
    
    /*
     * Special Methods
     */
    //start
    public final ResponseStatus clearExpiredSessions(final int seconds) throws SQLException {
        statement = connection.prepareCall("CALL ClearExpiredSessions(?);");
        statement.setInt(1, seconds);
        return getStatus(statement.executeQuery());
    }
    //end
    
    private boolean checkError(ResultSet result) {
        try {
            result.next();
            result.findColumn("status");
            return result.getInt(1) == 1;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    private String strip(String str, int maxLength) {
        return (str.trim().length() > maxLength) ? str.trim().substring(0, maxLength) : str.trim();
    }
    
    private ResponseStatus getStatus(ResultSet result) throws SQLException {
        result.next();
        ResponseStatus sr = new ResponseStatus();
        sr.status = result.getInt(1);
        sr.status_id = result.getInt(2);
        sr.status_msg = result.getString(3);
        return sr;
    }
}
