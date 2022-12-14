package MoreExerTeamworkProjects_04;

import java.util.List;

public class Team {
    private String name;
    private String creator;
    private List<String> userList;

    public Team(String name, String creator, List<String> userList){
        this.name = name;
        this.creator = creator;
        this.userList = userList;

    }

   public String getName() {
        return this.name;
   }

   public String getCreator() {
        return  this.creator;
   }

    public List<String> getUserList() {
        return this.userList;
    }

}
