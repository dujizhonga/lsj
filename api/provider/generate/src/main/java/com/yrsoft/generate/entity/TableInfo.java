package com.yrsoft.generate.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.yrsoft.common.utils.StringUtils;


import java.util.Date;
import java.util.List;

/**
 * ry 数据库表
 * 
 * @author yrsoft
 */
public class TableInfo
{
    private static final long serialVersionUID = 1L;

    /** 表名称 */
    private String tableName;

    /** 表描述 */
    private String tableComment;

    /** 表的主键列信息 */
    private ColumnInfo primaryKey;

    /** 表的列名(不包含主键) */
    private List<ColumnInfo> columns;

    /** 类名(第一个字母大写) */
    private String className;

    /** 类名(第一个字母小写) */
    private String classname;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableComment()
    {
        return tableComment;
    }

    public void setTableComment(String tableComment)
    {
        this.tableComment = tableComment;
    }

    public List<ColumnInfo> getColumns()
    {
        return columns;
    }

    public ColumnInfo getColumnsLast()
    {
        ColumnInfo columnInfo = null;
        if (StringUtils.isNotNull(columns) && columns.size() > 0)
        {
            columnInfo = columns.get(0);
        }
        return columnInfo;
    }

    public void setColumns(List<ColumnInfo> columns)
    {
        this.columns = columns;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassname()
    {
        return classname;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

    public ColumnInfo getPrimaryKey()
    {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnInfo primaryKey)
    {
        this.primaryKey = primaryKey;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
