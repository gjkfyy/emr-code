package szlh.iih.mr.po;

import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = IemrDocContentListener.class)
@Table(name = "iemr_doc_content")
public class IemrDocContent {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    /** */
    @Column(name = "encounter_id")
    String encounterId;

    /** */
    @Column(name = "doc_type")
    String docType;

    /** */
    @Column(name = "create_date")
    Timestamp createDate;

    /** */
    @Column(name = "creator")
    String creator;

    /** */
    @Column(name = "doc_id")
    String docId;

    /** */
    @Column(name = "doc_name")
    String docName;

    /** */
    @Column(name = "doc_content")
    String docContent;

    /** */
    @Column(name = "message_id")
    String messageId;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * Returns the encounterId.
     * 
     * @return the encounterId
     */
    public String getEncounterId() {
        return encounterId;
    }

    /** 
     * Sets the encounterId.
     * 
     * @param encounterId the encounterId
     */
    public void setEncounterId(String encounterId) {
        this.encounterId = encounterId;
    }

    /** 
     * Returns the docType.
     * 
     * @return the docType
     */
    public String getDocType() {
        return docType;
    }

    /** 
     * Sets the docType.
     * 
     * @param docType the docType
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /** 
     * Returns the createDate.
     * 
     * @return the createDate
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /** 
     * Sets the createDate.
     * 
     * @param createDate the createDate
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /** 
     * Returns the creator.
     * 
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /** 
     * Sets the creator.
     * 
     * @param creator the creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /** 
     * Returns the docId.
     * 
     * @return the docId
     */
    public String getDocId() {
        return docId;
    }

    /** 
     * Sets the docId.
     * 
     * @param docId the docId
     */
    public void setDocId(String docId) {
        this.docId = docId;
    }

    /** 
     * Returns the docName.
     * 
     * @return the docName
     */
    public String getDocName() {
        return docName;
    }

    /** 
     * Sets the docName.
     * 
     * @param docName the docName
     */
    public void setDocName(String docName) {
        this.docName = docName;
    }

    /** 
     * Returns the docContent.
     * 
     * @return the docContent
     */
    public String getDocContent() {
        return docContent;
    }

    /** 
     * Sets the docContent.
     * 
     * @param docContent the docContent
     */
    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    /** 
     * Returns the messageId.
     * 
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /** 
     * Sets the messageId.
     * 
     * @param messageId the messageId
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}