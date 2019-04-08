package com.osp.nova.cqsdc.graphql.datasources.mysql.nssa.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="host")
public class Host {
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @GeneratedValue(generator="system-uuid")
    private String uuid;

    private String name;

    private String assetId;

    private String groupId;

    private String msg;

    private String ip;

    private Integer type;

    private Integer value;

    private String mac;

    private String os;

    private String source;

    private Integer score;

    private Integer scoreInc;

    private Integer isTrusted;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}
