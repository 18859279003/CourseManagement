package xmu.crms.vo;
/**
 * 
 * @author R212-1
 *
 */
public class ScoreVo {

    private String topic;
    private String groupName;
    private String leaderName;
    private Integer presentationGrade;
    private Integer reportGrade;
    private Integer grade;
    private String report;
    
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getPresentationGrade() {
        return presentationGrade;
    }
    public void setPresentationGrade(Integer presentationGrade) {
        this.presentationGrade = presentationGrade;
    }
    public Integer getReportGrade() {
        return reportGrade;
    }
    public void setReportGrade(Integer reportGrade) {
        this.reportGrade = reportGrade;
    }
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public String getReport() {
        return report;
    }
    public void setReport(String report) {
        this.report = report;
    }
    public String getLeaderName() {
        return leaderName;
    }
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}
