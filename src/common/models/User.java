package common.models;

import java.util.Arrays;

public class User {
    public String name;
    public String u_id;
    public String[] permissions;

    public void getUserByName(String name){
        //Query the user table by name and create a user object

        // sample data from server
        String U_ID_fromServer = "123";
        String[] permissions_fromServer = {"create_bb","edit_all_bb","schedule_bb","edit_user"};

        this.permissions = permissions_fromServer;
        this.u_id = U_ID_fromServer;
        this.name = name;
    }

    public void getUserById(String u_id){
        //Query the user table by name and create a user object

        // sample data from server
        String name_fromServer = "Zeegaroot";
        String[] permissions_fromServer = {"create_bb","edit_all_bb","schedule_bb","edit_user"};

        this.permissions = permissions_fromServer;
        this.name = name_fromServer;
        this.u_id = u_id;
    }

    public Boolean isAllowedTo(String permissionName){
        return Arrays.asList(this.permissions).contains(permissionName);
    }

}
