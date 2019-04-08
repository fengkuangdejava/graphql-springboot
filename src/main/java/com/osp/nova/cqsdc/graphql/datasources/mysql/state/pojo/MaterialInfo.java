package com.osp.nova.cqsdc.graphql.datasources.mysql.state.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "material_info")
public class MaterialInfo {

    @Id
    private String materialDomain;

    private String attackSrcIp;

    private String attackDstIp;

    private String materialIp;

    private Integer isNestedMaterial;

    private Integer materialTimes;

    private Integer attackIpNumber;

    private String nestedMaterials;

    private Date createDate;

    private Date updateDate;

    private String domianStatus;

    private String materialRegistrantPerson;

    private String materialRegistrantEmail;
}
