package MoreExerTeamworkProjects_04;

import java.util.List;

public class Team {
    private String creator;
    private List<String> userList;

    public Team(String creator, List<String> userList){
        this.creator = creator;
        this.userList = userList;

    }

    public String getCreator(){
        return this.creator;
    }

}
