package xmu.crms.VO;

import java.util.Arrays;

import xmu.crms.entity.User;

public class ClassGroupVO {
    private User leader;
    private User[] members;

    public ClassGroupVO() {

    }
    public ClassGroupVO(User leader, User[] members) {
        this.leader = leader;
        this.members = members;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public User[] getMembers() {
        return members;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "ClassGroup{" +
                "leader=" + leader +
                ", members=" + Arrays.toString(members) +
                '}';
    }
}