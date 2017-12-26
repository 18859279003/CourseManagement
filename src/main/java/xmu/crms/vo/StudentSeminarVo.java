package xmu.crms.vo;
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class StudentSeminarVo {
    private int id;
    private String name;
    private String groupingMethod;
    private String courseName;
    private String startTime;
    private String endTime;
    private int classCalling;
    private boolean leaderSign;
    private boolean areTopicsSelected;

    public StudentSeminarVo() {

    }
    public StudentSeminarVo(int id, String name, String groupingMethod,
                          String courseName, String startTime, String endTime,
                          int classCalling, boolean isLeader, boolean areTopicsSelected) {
        this.id = id;
        this.name = name;
        this.groupingMethod = groupingMethod;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classCalling = classCalling;
        this.leaderSign = isLeader;
        this.areTopicsSelected = areTopicsSelected;
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

    public String getGroupingMethod() {
        return groupingMethod;
    }

    public void setGroupingMethod(String groupingMethod) {
        this.groupingMethod = groupingMethod;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getClassCalling() {
        return classCalling;
    }

    public void setClassCalling(int classCalling) {
        this.classCalling = classCalling;
    }

    public boolean isLeader() {
        return leaderSign;
    }

    public void setLeader(boolean leader) {
        leaderSign = leader;
    }

    public boolean isAreTopicsSelected() {
        return areTopicsSelected;
    }

    public void setAreTopicsSelected(boolean areTopicsSelected) {
        this.areTopicsSelected = areTopicsSelected;
    }

    @Override
    public String toString() {
        return "StudentSeminar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupingMethod='" + groupingMethod + '\'' +
                ", courseName='" + courseName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", classCalling=" + classCalling +
                ", isLeader=" + leaderSign +
                ", areTopicsSelected=" + areTopicsSelected +
                '}';
    }
}
