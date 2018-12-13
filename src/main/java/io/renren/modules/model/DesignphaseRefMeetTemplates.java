package io.renren.modules.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "designphase_ref_meet_templates")
public class DesignphaseRefMeetTemplates {
    @Column(name = "meet_template_id")
    private Long meetTemplateId;

    @Column(name = "designphase_id")
    private Long designphaseId;

    /**
     * @return meet_template_id
     */
    public Long getMeetTemplateId() {
        return meetTemplateId;
    }

    /**
     * @param meetTemplateId
     */
    public void setMeetTemplateId(Long meetTemplateId) {
        this.meetTemplateId = meetTemplateId;
    }

    /**
     * @return designphase_id
     */
    public Long getDesignphaseId() {
        return designphaseId;
    }

    /**
     * @param designphaseId
     */
    public void setDesignphaseId(Long designphaseId) {
        this.designphaseId = designphaseId;
    }
}