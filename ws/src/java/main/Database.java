/*
 * This contains the mapping of SQL stored procedures to the web server.
 */
package main;

import java.sql.*;
import java.util.ArrayList;

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
     * Database Interface Methods
     */
    public final StatusResponse clearExpiredSessions(final int seconds) throws SQLException {
        statement = connection.prepareCall("CALL ClearExpiredSessions(?);");
        statement.setInt(1, seconds);
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse createAccount(final CreateAccount params) throws SQLException {
        statement = connection.prepareCall("CALL CreateAccount(?,?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.password, 60));
        statement.setString(3, strip(params.name, 128));
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse createBranch(final CreateBranch params) throws SQLException {
        statement = connection.prepareCall("CALL CreateBranch(?,?,?,?,?,?,?);");
        statement.setString(1, strip(params.brand, 30));
        statement.setString(2, strip(params.name, 60));
        statement.setString(3, strip(params.category, 30));
        statement.setString(4, strip(params.type, 8));
        if (params.latitude == -999f) {
            statement.setNull(5, Types.FLOAT);
        } else {
            statement.setFloat(5, params.latitude);
        }
        if (params.longitude == -999f) {
            statement.setNull(6, Types.FLOAT);
        } else {
            statement.setFloat(6, params.longitude);
        }
        statement.setString(7, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse editAccount(final EditAccount params) throws SQLException {
        statement = connection.prepareCall("CALL EditAccount(?,?,?,?);");
        if (params.username.trim().equalsIgnoreCase("-999")) {
            statement.setNull(1, Types.CHAR);
        } else {
            statement.setString(1, strip(params.username, 60));
        }
        if (params.password.trim().equalsIgnoreCase("-999")) {
            statement.setNull(2, Types.CHAR);
        } else {
            statement.setString(2, strip(params.password, 60));
        }
        if (params.name.trim().equalsIgnoreCase("-999")) {
            statement.setNull(3, Types.VARCHAR);
        } else {
            statement.setString(3, strip(params.name, 128));
        }
        statement.setString(4, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse editBranch(final EditBranch params) throws SQLException {
        statement = connection.prepareCall("CALL EditBranch(?,?,?,?,?,?,?,?);");
        statement.setInt(1, params.id);
        if (params.brand.trim().equalsIgnoreCase("-999")) {
            statement.setNull(2, Types.VARCHAR);
        } else {
            statement.setString(2, strip(params.brand, 30));
        }
        if (params.name.trim().equalsIgnoreCase("-999")) {
            statement.setNull(3, Types.VARCHAR);
        } else {
            statement.setString(3, strip(params.name, 60));
        }
        if (params.category.trim().equalsIgnoreCase("-999")) {
            statement.setNull(4, Types.VARCHAR);
        } else {
            statement.setString(4, strip(params.category, 30));
        }
        if (params.type.trim().equalsIgnoreCase("-999")) {
            statement.setNull(5, Types.CHAR);
        } else {
            statement.setString(5, strip(params.type, 8));
        }
        if (params.latitude == -999f) {
            statement.setNull(6, Types.FLOAT);
        } else {
            statement.setFloat(6, params.latitude);
        }
        if (params.longitude == -999f) {
            statement.setNull(7, Types.FLOAT);
        } else {
            statement.setFloat(7, params.longitude);
        }
        statement.setString(8, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final BranchResponse getAllBranches(final Session params) throws SQLException {
        statement = connection.prepareCall("CALL GetAllBranches(?);");
        statement.setString(1, strip(params.session, 64));
        ResultSet result =  statement.executeQuery();
        BranchResponse br = new BranchResponse();
        ArrayList<Branch> list = new ArrayList<>();
        while (result.next()) {
            Branch b = new Branch();
            b.id = result.getInt(1);
            b.brand = result.getString(2);
            b.name = result.getString(3);
            b.category = result.getString(4);
            b.type = result.getString(5);
            b.latitude = result.getFloat(6);
            b.longitude = result.getFloat(7);
            list.add(b);
        }
        br.branches = list;
        return br;
    }
    
    public final Serving getServingNumber(final BranchSession params) throws SQLException {
        statement = connection.prepareCall("CALL GetServingNumber(?,?);");
        statement.setInt(1, params.branch);
        statement.setString(2, strip(params.session, 64));
        ResultSet result = statement.executeQuery();
        result.next();
        Serving s = new Serving();
        s.serving = result.getInt(1);
        return s;
    }
    
    public final BranchResponse getBranchesFromBrand(final GetBranchesFromBrand params) throws SQLException {
        statement = connection.prepareCall("CALL GetBranchesFromBrand(?,?);");
        statement.setString(1, strip(params.brand, 64));
        statement.setString(2, strip(params.session, 64));
        ResultSet result =  statement.executeQuery();
        BranchResponse br = new BranchResponse();
        ArrayList<Branch> list = new ArrayList<>();
        while (result.next()) {
            Branch b = new Branch();
            b.id = result.getInt(1);
            b.brand = result.getString(2);
            b.name = result.getString(3);
            b.category = result.getString(4);
            b.type = result.getString(5);
            b.latitude = result.getFloat(6);
            b.longitude = result.getFloat(7);
            list.add(b);
        }
        br.branches = list;
        return br;
    }
    
    public final BranchResponse getBranchesFromCategory(final GetBranchesFromCategory params) throws SQLException {
        statement = connection.prepareCall("CALL GetBranchesFromCategory(?,?);");
        statement.setString(1, strip(params.category, 30));
        statement.setString(2, strip(params.session, 64));
        ResultSet result =  statement.executeQuery();
        BranchResponse br = new BranchResponse();
        ArrayList<Branch> list = new ArrayList<>();
        while (result.next()) {
            Branch b = new Branch();
            b.id = result.getInt(1);
            b.brand = result.getString(2);
            b.name = result.getString(3);
            b.category = result.getString(4);
            b.type = result.getString(5);
            b.latitude = result.getFloat(6);
            b.longitude = result.getFloat(7);
            list.add(b);
        }
        br.branches = list;
        return br;
    }
    
    public final StatusResponse joinQueue(final BranchSession params) throws SQLException {
        statement = connection.prepareCall("CALL JoinQueue(?,?);");
        statement.setInt(1, params.branch);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse leaveQueue(final BranchSession params) throws SQLException {
        statement = connection.prepareCall("CALL LeaveQueue(?,?);");
        statement.setInt(1, params.branch);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final LoginResponse login(final Login params) throws SQLException, StatusException {
        statement = connection.prepareCall("CALL Login(?,?);");
        statement.setString(1, strip(params.username, 60));
        statement.setString(2, strip(params.password, 60));
        ResultSet result = statement.executeQuery();
        if (!checkError(result)) {
            LoginResponse lr = new LoginResponse();
            lr.session = result.getString(1);
            lr.username = result.getString(2);
            lr.name = result.getString(3);
            return lr;
        } else {
            throw new StatusException(result);
        }
    }
    
    public final StatusResponse logout(final Session params) throws SQLException {
        statement = connection.prepareCall("CALL Logout(?);");
        statement.setString(1, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse serveComplete(final BranchSession params) throws SQLException {
        statement = connection.prepareCall("CALL ServeComplete(?,?);");
        statement.setInt(1, params.branch);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
    public final StatusResponse serveNext(final BranchSession params) throws SQLException {
        statement = connection.prepareCall("CALL ServeNext(?,?);");
        statement.setInt(1, params.branch);
        statement.setString(2, strip(params.session, 64));
        return getStatus(statement.executeQuery());
    }
    
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
    
    private StatusResponse getStatus(ResultSet result) throws SQLException {
        result.next();
        StatusResponse sr = new StatusResponse();
        sr.status = result.getInt(1);
        sr.status_id = result.getInt(2);
        sr.status_msg = result.getString(3);
        return sr;
    }
}
