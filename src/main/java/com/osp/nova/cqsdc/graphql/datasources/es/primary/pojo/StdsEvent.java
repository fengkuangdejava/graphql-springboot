package com.osp.nova.cqsdc.graphql.datasources.es.primary.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: graphql-mudule
 * @description: stds事件
 * @author: liting
 * @create: 2019-04-02 18:02
 **/
@Data
@Entity
@Document(indexName = "stds", type = "data", refreshInterval = "0s")
public class StdsEvent {
    private String facility;
    private String host;
    @Id
    private String id;
    private String port;
    private String collectip;
    private String severity;
    private String timestamp;
    private String type;
    private String valid;
    private String version;
    private String stds_ingest_valid_processing_dttm;
    private String shost;
    private String srcip;
    private String dstip;
    private String method;
    private String uri;
    private String baseurl;
    private String version_;
    private String host_;
    private String useragent;
    private String referer;
    private String reqbodypath;
    private String resbodypath;
    private String reqheaders;
    private String ruleid;
    private String ruletype;
    private String category;
    private String rulename;
    private String fingerprint;
    private String srclocation;
    private String dstlocation;
    private String srccountry;
    private String dstcountry;
    private String os;
    private String browser;
    private String attack_tags;
    private String cleaning_tags;
    private String nova_schema;
    private String nova_table;
    private long receivetime;
    private long ctime;
    private long logtime;
    private long srcport;
    private long dstport;
    private long status;
    private long rulelevel;
    private long subcategory;
    private long ssubcategory;
    private long detstatus;
    private long killchaintype;
    private long srclatitude;
    private long srclongitude;
    private long dstlatitude;
    private long dstlongitude;
    private long srcintranet;
    private long dstintranet;
    private long isstepping;

}
