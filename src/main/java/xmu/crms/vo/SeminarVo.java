package xmu.crms.vo;

import java.util.Arrays;

import xmu.crms.entity.Topic;
/**
 * 
 * @author Zhuang Dandan
 *
 */
public class SeminarVo {
    private int id;
    private String name;
    private String description;
    private String groupingMethod;
    private String startTime;
	private String endTime;
    private Topic[] topics;

    public SeminarVo() {

    }
    public SeminarVo(int id, String name, String description, String groupingMethod, String startTime, String endTime,
            Topic[] topics) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.groupingMethod = groupingMethod;
        this.startTime = startTime;
        this.endTime = endTime;
        this.topics = topics;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupingMethod() {
        return groupingMethod;
    }

    public void setGroupingMethod(String groupingMethod) {
        this.groupingMethod = groupingMethod;
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

    public Topic[] getTopics() {
        return topics;
    }

    public void setTopics(Topic[] topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", groupingMethod='" + groupingMethod + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", topic=" + Arrays.toString(topics) +
                '}';
    }

}
