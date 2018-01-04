package xmu.crms.vo;

import java.math.BigInteger;
import java.util.Arrays;

import xmu.crms.entity.User;
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class ClassGroupVo {
    private BigInteger id;
    private User leader;
    private User[] members;

    
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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
