package com.wipe.healthy.core.model;

/**
 * 城市数据持久层实体
 * User:Created by wei.li
 * Date: on 2015/12/22.
 * Time:22:37
 */
public class City {

    /** 城市主键**/
    private Integer id;

    /** 城市父节点id**/
    private Integer parentId;

    /** 城市代码**/
    private String code;

    /** 城市名称**/
    private String name;

    /** 城市类型**/
    private Integer type;

    /** 是否是叶子节点（0:是 1:不是）**/
    private Integer leaf;

    /** 城市排序**/
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (code != null ? !code.equals(city.code) : city.code != null) return false;
        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (leaf != null ? !leaf.equals(city.leaf) : city.leaf != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (parentId != null ? !parentId.equals(city.parentId) : city.parentId != null) return false;
        if (sort != null ? !sort.equals(city.sort) : city.sort != null) return false;
        if (type != null ? !type.equals(city.type) : city.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (leaf != null ? leaf.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", leaf=" + leaf +
                ", sort=" + sort +
                '}';
    }
}
