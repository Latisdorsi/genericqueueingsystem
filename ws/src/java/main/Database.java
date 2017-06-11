/*
 * This contains the mapping of SQL stored procedures to the web server.
 */
package main;

import java.sql.*;
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
        statement.setString(2, strip(params.password, 60));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.type, 7));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus createManager(final ParamsAccountInfo params) throws SQLException {
        statement = connection.prepareCall("CALL CreateManager(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.password, 60));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus editCustomer(final ParamsAccountInfo params) throws SQLException {
        statement = connection.prepareCall("CALL EditCustomer(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.password, 60));
        statement.setString(3, strip(params.name, 128));
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus editManager(final ParamsAccountInfo params) throws SQLException {
        statement = connection.prepareCall("CALL EditManager(?,?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.password, 60));
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
     * CounterResource Methods
     */
    //start
    public final ResponseStatus joinQueue(final ParamsCounterSession params) throws SQLException {
        statement = connection.prepareCall("CALL JoinQueue(?,?);");
        statement.setInt(1, params.counter);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final ResponseStatus leaveQueue(final ParamsCounterSession params) throws SQLException {
        statement = connection.prepareCall("CALL LeaveQueue(?,?);");
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
