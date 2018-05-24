package org.hibernate.loader.sample;

import javax.persistence.*;
import java.io.Serializable;
@Entity(name = "GamificationContextItem")
@Table(name = "GAMIFICATION_CONTEXT_ITEM")
public class GamificationContextItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "ZONE")
    protected String zone;

    @Column(name = "OPERATION_TYPE")
    protected String opType;

    @Column(name = "OCCURRENCE")
    protected int occurrence;

    // Master relationship GamificationScore(many) -> GamificationUser (one)
    // Foreign key is used within GamificationContextItemEntity (gamification_user_id)
    // 1 GamificationScore must necessarily have 1 GamificationUser (nullable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gamification_user_id", nullable = false)
    private GamificationContextEntity gamificationUserEntity;

    public GamificationContextItemEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public GamificationContextEntity getGamificationUserEntity() {
        return gamificationUserEntity;
    }

    public void setGamificationUserEntity(GamificationContextEntity gamificationUserEntity) {
        this.gamificationUserEntity = gamificationUserEntity;
    }

    public String toString() {
        return String.format("Gamification[%d,%s,%d,%d]", id, zone, occurrence, gamificationUserEntity.getId());

    }
}