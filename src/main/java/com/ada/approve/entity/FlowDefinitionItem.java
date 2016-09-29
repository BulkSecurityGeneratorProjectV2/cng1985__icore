package com.ada.approve.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 流程定义节点
 *
 * @author ada
 */
@Entity
@Table(name = "approve_flow_definition_item")
public class FlowDefinitionItem extends AbstractEntity {

    private String type;

    /**
     * 审批人
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    /**
     * 流程
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private FlowDefinition flow;

    /**
     * 审批节点名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer hierarchy;

    public String getType() {
        return type;
    }

    public FlowDefinition getFlow() {
        return flow;
    }

    public void setFlow(FlowDefinition flow) {
        this.flow = flow;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
