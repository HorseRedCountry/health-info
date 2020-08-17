package com.wipe.healthy.core.model;

/**
 * 数据持久层用户健身行为实体
 * User:Created by wei.li
 * Date: on 2015/12/8.
 * Time:23:55
 */
public class FitnessAction {

    /**健身行为id**/
    private Integer id;

    /**健身行为名称**/
    private String actionName;

    /**健身行为类型**/
    private Integer style;

    /**健身行为适用人群**/
    private String fitPeople;

    /**健身行为消耗卡路里**/
    private Float calorie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getFitPeople() {
        return fitPeople;
    }

    public void setFitPeople(String fitPeople) {
        this.fitPeople = fitPeople;
    }

    public Float getCalorie() {
        return calorie;
    }

    public void setCalorie(Float calorie) {
        this.calorie = calorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FitnessAction that = (FitnessAction) o;

        if (actionName != null ? !actionName.equals(that.actionName) : that.actionName != null) return false;
        if (calorie != null ? !calorie.equals(that.calorie) : that.calorie != null) return false;
        if (fitPeople != null ? !fitPeople.equals(that.fitPeople) : that.fitPeople != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (actionName != null ? actionName.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (fitPeople != null ? fitPeople.hashCode() : 0);
        result = 31 * result + (calorie != null ? calorie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FitnessAction{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", style=" + style +
                ", fitPeople='" + fitPeople + '\'' +
                ", calorie=" + calorie +
                '}';
    }
}
