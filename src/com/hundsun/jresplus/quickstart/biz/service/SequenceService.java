/**
* <p>Title: </p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2008</p>
* <p>Company: soft.buylog.cn</p>
* @author :James Lee
* @version 1.0
*/
package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import javax.sound.midi.Sequence;

public interface SequenceService {

    public List getAllSequence();

    public Sequence getSequenceByTablename(String tablename);

    public void addSequence(Sequence sequence);

    public void removeSequence(String tablename);

    public void updateSequence(Sequence sequence);

    public void increaseSeqno(String tablenamee);

    public Integer getMaxSeqno(String tablename);

    public Integer genValidSeqno(String tablename);
}
