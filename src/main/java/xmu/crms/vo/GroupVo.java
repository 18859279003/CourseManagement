package xmu.crms.vo;

import java.util.Arrays;

import xmu.crms.entity.Topic;
import xmu.crms.entity.User;

public class GroupVo {
    private int id;
    private String name;
    private User leader;
    private User[] members;
    private Topic[] topics;
    private String report;

    public GroupVo() {

    }

    public GroupVo(int id, String name, User leader, User[] members, Topic[] topics, String report) {
        super();
        this.id = id;
        this.name = name;
        this.leader = leader;
        this.members = members;
        this.topics = topics;
        this.report = report;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Topic[] getTopics() {
        return topics;
    }

    public void setTopics(Topic[] topics) {
        this.topics = topics;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "GroupVO [id=" + id + ", name=" + name + ", leader=" + leader + ", members=" + Arrays.toString(members)
                + ", topics=" + Arrays.toString(topics) + ", report=" + report + "]";
    }
}
