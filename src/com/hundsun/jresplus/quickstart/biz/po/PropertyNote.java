package com.hundsun.jresplus.quickstart.biz.po;

/**
 * 
 * @author chengy
 * @version $Id: PropertyNote.java,v 0.1 2015年6月17日 下午10:33:10 chengy Exp $
 */
public class PropertyNote extends BaseDomain {

    private static final long serialVersionUID = -586076967725559318L;

    String noteContent;
    
    String noteBg;

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteBg() {
        return noteBg;
    }

    public void setNoteBg(String noteBg) {
        this.noteBg = noteBg;
    }
    
    
}
