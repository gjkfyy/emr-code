package pkuhit.iih.mr.tth.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = MrTeethExamItemListener.class)
@Table(name = "MR_TEETH_EXAM_ITEM")
public class MrTeethExamItem
{
    /** 主键 */
    @Id
    @Column(name = "TEETH_ITEM_PK")
    String teethItemPk;
    
    /** 外键*/
    @Column(name = "TEETH_PK")
    String teethPk;
    
    /** 牙位*/
    @Column(name = "TEETH_LOCATION")
    String teethLocation;
    
    /** 第1颗牙FI的第1个值*//*
    @Column(name = "FST_FI_FST")
    String fstFiFst;
    
    *//** 第1颗牙FI的第2个值*//*
    @Column(name = "FST_FI_SND")
    String fstFiSnd;
    
    *//** 第1颗牙FI的第3个值*//*
    @Column(name = "FST_FI_TRD")
    String fstFiTrd;
    
    *//** 第2颗牙FI的第1个值*//*
    @Column(name = "SND_FI_FST")
    String sndFiFst;
    
    *//** 第2颗牙FI的第2个值*//*
    @Column(name = "SND_FI_SND")
    String sndFiSnd;
    
    *//** 第2颗牙FI的第3个值*//*
    @Column(name = "SND_FI_TRD")
    String sndFiTrd;
    
    *//** 第3颗牙FI的第1个值*//*
    @Column(name = "TRD_FI_FST")
    String trdFiFst;
    
    *//** 第3颗牙FI的第2个值*//*
    @Column(name = "TRD_FI_SND")
    String trdFiSnd;
    
    *//** 第3颗牙FI的第3个值*//*
    @Column(name = "TRD_FI_TRD")
    String trdFiTrd;
    
    *//** 第1颗牙角化龈宽的第1个值*//*
    @Column(name = "FST_KT_FST")
    String fstKtFst;
    
    *//** 第1颗牙角化龈宽的第2个值*//*
    @Column(name = "FST_KT_SND")
    String fstKtSnd;
    
    *//** 第1颗牙角化龈宽的第3个值*//*
    @Column(name = "FST_KT_TRD")
    String fstKtTrd;
    
    *//** 第1颗牙角化龈宽的第4个值*//*
    @Column(name = "FST_KT_FOH")
    String fstKtFoh;
    
    *//** 第1颗牙角化龈宽的第5个值*//*
    @Column(name = "FST_KT_FIH")
    String fstKtFih;
    
    *//** 第1颗牙角化龈宽的第6个值*//*
    @Column(name = "FST_KT_SIX")
    String fstKtSix;
    
    *//** 第2颗牙角化龈宽的第1个值*//*
    @Column(name = "SND_KT_FST")
    String sndKtFst;
    
    *//** 第2颗牙角化龈宽的第2个值*//*
    @Column(name = "SND_KT_SND")
    String sndKtSnd;
    
    *//** 第2颗牙角化龈宽的第3个值*//*
    @Column(name = "SND_KT_TRD")
    String sndKtTrd;
    
    *//** 第2颗牙角化龈宽的第4个值*//*
    @Column(name = "SND_KT_FOH")
    String sndKtFoh;
    
    *//** 第2颗牙角化龈宽的第5个值*//*
    @Column(name = "SND_KT_FIH")
    String sndKtFih;
    
    *//** 第2颗牙角化龈宽的第6个值*//*
    @Column(name = "SND_KT_SIX")
    String sndKtSix;
    
    *//** 第3颗牙角化龈宽的第1个值*//*
    @Column(name = "TRD_KT_FST")
    String trdKtFst;
    
    *//** 第3颗牙角化龈宽的第2个值*//*
    @Column(name = "TRD_KT_SND")
    String trdKtSnd;
    
    *//** 第3颗牙角化龈宽的第3个值*//*
    @Column(name = "TRD_KT_TRD")
    String trdKtTrd;
    
    *//** 第3颗牙角化龈宽的第4个值*//*
    @Column(name = "TRD_KT_FOH")
    String trdKtFoh;
    
    *//** 第3颗牙角化龈宽的第5个值*//*
    @Column(name = "TRD_KT_FIH")
    String trdKtFih;
    
    *//** 第3颗牙角化龈宽的第6个值*//*
    @Column(name = "TRD_KT_SIX")
    String trdKtSix;
    
    *//** 第4颗牙角化龈宽的第1个值*//*
    @Column(name = "FOH_KT_FST")
    String fohKtFst;
    
    *//** 第4颗牙角化龈宽的第2个值*//*
    @Column(name = "FOH_KT_SND")
    String fohKtSnd;
    
    *//** 第4颗牙角化龈宽的第3个值*//*
    @Column(name = "FOH_KT_TRD")
    String fohKtTrd;
    
    *//** 第4颗牙角化龈宽的第4个值*//*
    @Column(name = "FOH_KT_FOH")
    String fohKtFoh;
    
    *//** 第4颗牙角化龈宽的第5个值*//*
    @Column(name = "FOH_KT_FIH")
    String fohKtFih;
    
    *//** 第4颗牙角化龈宽的第6个值*//*
    @Column(name = "FOH_KT_SIX")
    String fohKtSix;
    
    *//** 第5颗牙角化龈宽的第1个值*//*
    @Column(name = "FIH_KT_FST")
    String fihKtFst;
    
    *//** 第5颗牙角化龈宽的第2个值*//*
    @Column(name = "FIH_KT_SND")
    String fihKtSnd;
    
    *//** 第5颗牙角化龈宽的第3个值*//*
    @Column(name = "FIH_KT_TRD")
    String fihKtTrd;
    
    *//** 第5颗牙角化龈宽的第4个值*//*
    @Column(name = "FIH_KT_FOH")
    String fihKtFoh;
    
    *//** 第5颗牙角化龈宽的第5个值*//*
    @Column(name = "FIH_KT_FIH")
    String fihKtFih;
    
    *//** 第5颗牙角化龈宽的第6个值*//*
    @Column(name = "FIH_KT_SIX")
    String fihKtSix;
    
    *//** 第6颗牙角化龈宽的第1个值*//*
    @Column(name = "SIX_KT_FST")
    String sixKtFst;
    
    *//** 第6颗牙角化龈宽的第2个值*//*
    @Column(name = "SIX_KT_SND")
    String sixKtSnd;
    
    *//** 第6颗牙角化龈宽的第3个值*//*
    @Column(name = "SIX_KT_TRD")
    String sixKtTrd;
    
    *//** 第6颗牙角化龈宽的第4个值*//*
    @Column(name = "SIX_KT_FOH")
    String sixKtFoh;
    
    *//** 第6颗牙角化龈宽的第5个值*//*
    @Column(name = "SIX_KT_FIH")
    String sixKtFih;
    
    *//** 第6颗牙角化龈宽的第6个值*//*
    @Column(name = "SIX_KT_SIX")
    String sixKtSix;
    
    *//** 第7颗牙角化龈宽的第1个值*//*
    @Column(name = "SVN_KT_FST")
    String svnKtFst;
    
    *//** 第7颗牙角化龈宽的第2个值*//*
    @Column(name = "SVN_KT_SND")
    String svnKtSnd;
    
    *//** 第7颗牙角化龈宽的第3个值*//*
    @Column(name = "SVN_KT_TRD")
    String svnKtTrd;
    
    *//** 第7颗牙角化龈宽的第4个值*//*
    @Column(name = "SVN_KT_FOH")
    String svnKtFoh;
    
    *//** 第7颗牙角化龈宽的第5个值*//*
    @Column(name = "SVN_KT_FIH")
    String svnKtFih;
    
    *//** 第7颗牙角化龈宽的第6个值*//*
    @Column(name = "SVN_KT_SIX")
    String svnKtSix;
    
    *//** 第8颗牙角化龈宽的第1个值*//*
    @Column(name = "ETH_KT_FST")
    String ethKtFst;
    
    *//** 第8颗牙角化龈宽的第2个值*//*
    @Column(name = "ETH_KT_SND")
    String ethKtSnd;
    
    *//** 第8颗牙角化龈宽的第3个值*//*
    @Column(name = "ETH_KT_TRD")
    String ethKtTrd;
    
    *//** 第8颗牙角化龈宽的第4个值*//*
    @Column(name = "ETH_KT_FOH")
    String ethKtFoh;
    
    *//** 第8颗牙角化龈宽的第5个值*//*
    @Column(name = "ETH_KT_FIH")
    String ethKtFih;
    
    *//** 第8颗牙角化龈宽的第6个值*//*
    @Column(name = "ETH_KT_SIX")
    String ethKtSix;
    
    *//** 第1颗牙溢脓的第1个值*//*
    @Column(name = "FST_OP_FST")
    String fstOpFst;
    
    *//** 第1颗牙溢脓的第2个值*//*
    @Column(name = "FST_OP_SND")
    String fstOpSnd;
    
    *//** 第2颗牙溢脓的第1个值*//*
    @Column(name = "SND_OP_FST")
    String sndOpFst;
    
    *//** 第2颗牙溢脓的第2个值*//*
    @Column(name = "SND_OP_SND")
    String sndOpSnd;
    
    *//** 第3颗牙溢脓的第1个值*//*
    @Column(name = "TRD_OP_FST")
    String trdOpFst;
    
    *//** 第3颗牙溢脓的第2个值*//*
    @Column(name = "TRD_OP_SND")
    String trdOpSnd;
    
    *//** 第4颗牙溢脓的第1个值*//*
    @Column(name = "FOH_OP_FST")
    String fohOpFst;
    
    *//** 第4颗牙溢脓的第2个值*//*
    @Column(name = "FOH_OP_SND")
    String fohOpSnd;
    
    *//** 第5颗牙溢脓的第1个值*//*
    @Column(name = "FIH_OP_FST")
    String fihOpFst;
    
    *//** 第5颗牙溢脓的第2个值*//*
    @Column(name = "FIH_OP_SND")
    String fihOpSnd;
    
    *//** 第6颗牙溢脓的第1个值*//*
    @Column(name = "SIX_OP_FST")
    String sixOpFst;
    
    *//** 第6颗牙溢脓的第2个值*//*
    @Column(name = "SIX_OP_SND")
    String sixOpSnd;
    
    *//** 第7颗牙溢脓的第1个值*//*
    @Column(name = "SVN_OP_FST")
    String svnOpFst;
    
    *//** 第7颗牙溢脓的第2个值*//*
    @Column(name = "SVN_OP_SND")
    String svnOpSnd;
    
    *//** 第8颗牙溢脓的第1个值*//*
    @Column(name = "ETH_OP_FST")
    String ethOpFst;
    
    *//** 第8颗牙溢脓的第2个值*//*
    @Column(name = "ETH_OP_SND")
    String ethOpSnd;
    
    *//** 第1颗牙动度的第1个值*//*
    @Column(name = "FST_MB_FST")
    String fstMbFst;
    
    *//** 第1颗牙动度的第2个值*//*
    @Column(name = "FST_MB_SND")
    String fstMbSnd;
    
    *//** 第2颗牙动度的第1个值*//*
    @Column(name = "SND_MB_FST")
    String sndMbFst;
    
    *//** 第2颗牙动度的第2个值*//*
    @Column(name = "SND_MB_SND")
    String sndMbSnd;
    
    *//** 第3颗牙动度的第1个值*//*
    @Column(name = "TRD_MB_FST")
    String trdMbFst;
    
    *//** 第3颗牙动度的第2个值*//*
    @Column(name = "TRD_MB_SND")
    String trdMbSnd;
    
    *//** 第4颗牙动度的第1个值*//*
    @Column(name = "FOH_MB_FST")
    String fohMbFst;
    
    *//** 第4颗牙动度的第2个值*//*
    @Column(name = "FOH_MB_SND")
    String fohMbSnd;
    
    *//** 第5颗牙动度的第1个值*//*
    @Column(name = "FIH_MB_FST")
    String fihMbFst;
    
    *//** 第5颗牙动度的第2个值*//*
    @Column(name = "FIH_MB_SND")
    String fihMbSnd;
    
    *//** 第6颗牙动度的第1个值*//*
    @Column(name = "SIX_MB_FST")
    String sixMbFst;
    
    *//** 第6颗牙动度的第2个值*//*
    @Column(name = "SIX_MB_SND")
    String sixMbSnd;
    
    *//** 第7颗牙动度的第1个值*//*
    @Column(name = "SVN_MB_FST")
    String svnMbFst;
    
    *//** 第7颗牙动度的第2个值*//*
    @Column(name = "SVN_MB_SND")
    String svnMbSnd;
    
    *//** 第8颗牙动度的第1个值*//*
    @Column(name = "ETH_MB_FST")
    String ethMbFst;
    
    *//** 第8颗牙动度的第2个值*//*
    @Column(name = "ETH_MB_SND")
    String ethMbSnd;
    
    *//** 第1颗牙PLI的第1个值*//*
    @Column(name = "FST_PLI_FST")
    String fstPliFst;
    
    *//** 第1颗牙PLI的第2个值*//*
    @Column(name = "FST_PLI_SND")
    String fstPliSnd;
    
    *//** 第1颗牙PLI的第3个值*//*
    @Column(name = "FST_PLI_TRD")
    String fstPliTrd;
    
    *//** 第1颗牙PLI的第4个值*//*
    @Column(name = "FST_PLI_FOH")
    String fstPliFoh;
    
    *//** 第1颗牙PLI的第5个值*//*
    @Column(name = "FST_PLI_FIH")
    String fstPliFih;
    
    *//** 第1颗牙PLI的第6个值*//*
    @Column(name = "FST_PLI_SIX")
    String fstPliSix;
    
    *//** 第2颗牙PLI的第1个值*//*
    @Column(name = "SND_PLI_FST")
    String sndPliFst;
    
    *//** 第2颗牙PLI的第2个值*//*
    @Column(name = "SND_PLI_SND")
    String sndPliSnd;
    
    *//** 第2颗牙PLI的第3个值*//*
    @Column(name = "SND_PLI_TRD")
    String sndPliTrd;
    
    *//** 第2颗牙PLI的第4个值*//*
    @Column(name = "SND_PLI_FOH")
    String sndPliFoh;
    
    *//** 第2颗牙PLI的第5个值*//*
    @Column(name = "SND_PLI_FIH")
    String sndPliFih;
    
    *//** 第2颗牙PLI的第6个值*//*
    @Column(name = "SND_PLI_SIX")
    String sndPliSix;
    
    *//** 第3颗牙PLI的第1个值*//*
    @Column(name = "TRD_PLI_FST")
    String trdPliFst;
    
    *//** 第3颗牙PLI的第2个值*//*
    @Column(name = "TRD_PLI_SND")
    String trdPliSnd;
    
    *//** 第3颗牙PLI的第3个值*//*
    @Column(name = "TRD_PLI_TRD")
    String trdPliTrd;
    
    *//** 第3颗牙PLI的第4个值*//*
    @Column(name = "TRD_PLI_FOH")
    String trdPliFoh;
    
    *//** 第3颗牙PLI的第5个值*//*
    @Column(name = "TRD_PLI_FIH")
    String trdPliFih;
    
    *//** 第3颗牙PLI的第6个值*//*
    @Column(name = "TRD_PLI_SIX")
    String trdPliSix;
    
    *//** 第4颗牙PLI的第1个值*//*
    @Column(name = "FOH_PLI_FST")
    String fohPliFst;
    
    *//** 第4颗牙PLI的第2个值*//*
    @Column(name = "FOH_PLI_SND")
    String fohPliSnd;
    
    *//** 第4颗牙PLI的第3个值*//*
    @Column(name = "FOH_PLI_TRD")
    String fohPliTrd;
    
    *//** 第4颗牙PLI的第4个值*//*
    @Column(name = "FOH_PLI_FOH")
    String fohPliFoh;
    
    *//** 第4颗牙PLI的第5个值*//*
    @Column(name = "FOH_PLI_FIH")
    String fohPliFih;
    
    *//** 第4颗牙PLI的第6个值*//*
    @Column(name = "FOH_PLI_SIX")
    String fohPliSix;
    
    *//** 第5颗牙PLI的第1个值*//*
    @Column(name = "FIH_PLI_FST")
    String fihPliFst;
    
    *//** 第5颗牙PLI的第2个值*//*
    @Column(name = "FIH_PLI_SND")
    String fihPliSnd;
    
    *//** 第5颗牙PLI的第3个值*//*
    @Column(name = "FIH_PLI_TRD")
    String fihPliTrd;
    
    *//** 第5颗牙PLI的第4个值*//*
    @Column(name = "FIH_PLI_FOH")
    String fihPliFoh;
    
    *//** 第5颗牙PLI的第5个值*//*
    @Column(name = "FIH_PLI_FIH")
    String fihPliFih;
    
    *//** 第5颗牙PLI的第6个值*//*
    @Column(name = "FIH_PLI_SIX")
    String fihPliSix;
    
    *//** 第6颗牙PLI的第1个值*//*
    @Column(name = "SIX_PLI_FST")
    String sixPliFst;
    
    *//** 第6颗牙PLI的第2个值*//*
    @Column(name = "SIX_PLI_SND")
    String sixPliSnd;
    
    *//** 第6颗牙PLI的第3个值*//*
    @Column(name = "SIX_PLI_TRD")
    String sixPliTrd;
    
    *//** 第6颗牙PLI的第4个值*//*
    @Column(name = "SIX_PLI_FOH")
    String sixPliFoh;
    
    *//** 第6颗牙PLI的第5个值*//*
    @Column(name = "SIX_PLI_FIH")
    String sixPliFih;
    
    *//** 第6颗牙PLI的第6个值*//*
    @Column(name = "SIX_PLI_SIX")
    String sixPliSix;
    
    *//** 第7颗牙PLI的第1个值*//*
    @Column(name = "SVN_PLI_FST")
    String svnPliFst;
    
    *//** 第7颗牙PLI的第2个值*//*
    @Column(name = "SVN_PLI_SND")
    String svnPliSnd;
    
    *//** 第7颗牙PLI的第3个值*//*
    @Column(name = "SVN_PLI_TRD")
    String svnPliTrd;
    
    *//** 第7颗牙PLI的第4个值*//*
    @Column(name = "SVN_PLI_FOH")
    String svnPliFoh;
    
    *//** 第7颗牙PLI的第5个值*//*
    @Column(name = "SVN_PLI_FIH")
    String svnPliFih;
    
    *//** 第7颗牙PLI的第6个值*//*
    @Column(name = "SVN_PLI_SIX")
    String svnPliSix;
    
    *//** 第8颗牙PLI的第1个值*//*
    @Column(name = "ETH_PLI_FST")
    String ethPliFst;
    
    *//** 第8颗牙PLI的第2个值*//*
    @Column(name = "ETH_PLI_SND")
    String ethPliSnd;
    
    *//** 第8颗牙PLI的第3个值*//*
    @Column(name = "ETH_PLI_TRD")
    String ethPliTrd;
    
    *//** 第8颗牙PLI的第4个值*//*
    @Column(name = "ETH_PLI_FOH")
    String ethPliFoh;
    
    *//** 第8颗牙PLI的第5个值*//*
    @Column(name = "ETH_PLI_FIH")
    String ethPliFih;
    
    *//** 第8颗牙PLI的第6个值*//*
    @Column(name = "ETH_PLI_SIX")
    String ethPliSix;
    
    *//** 第1颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "FST_CEJ_FST")
    String fstCejFst;
    
    *//** 第1颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "FST_CEJ_SND")
    String fstCejSnd;
    
    *//** 第2颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "SND_CEJ_FST")
    String sndCejFst;
    
    *//** 第2颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "SND_CEJ_SND")
    String sndCejSnd;
    
    *//** 第3颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "TRD_CEJ_FST")
    String trdCejFst;
    
    *//** 第3颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "TRD_CEJ_SND")
    String trdCejSnd;
    
    *//** 第4颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "FOH_CEJ_FST")
    String fohCejFst;
    
    *//** 第4颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "FOH_CEJ_SND")
    String fohCejSnd;
    
    *//** 第5颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "FIH_CEJ_FST")
    String fihCejFst;
    
    *//** 第5颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "FIH_CEJ_SND")
    String fihCejSnd;
    
    *//** 第6颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "SIX_CEJ_FST")
    String sixCejFst;
    
    *//** 第6颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "SIX_CEJ_SND")
    String sixCejSnd;
    
    *//** 第7颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "SVN_CEJ_FST")
    String svnCejFst;
    
    *//** 第7颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "SVN_CEJ_SND")
    String svnCejSnd;
    
    *//** 第8颗牙龈缘-CEJ的第1个值*//*
    @Column(name = "ETH_CEJ_FST")
    String ethCejFst;
    
    *//** 第8颗牙龈缘-CEJ的第2个值*//*
    @Column(name = "ETH_CEJ_SND")
    String ethCejSnd;
    
    *//** 第1颗牙BI的第1个值*//*
    @Column(name = "FST_BI_FST")
    String fstBiFst;
    
    *//** 第1颗牙BI的第2个值*//*
    @Column(name = "FST_BI_SND")
    String fstBiSnd;
    
    *//** 第2颗牙BI的第1个值*//*
    @Column(name = "SND_BI_FST")
    String sndBiFst;
    
    *//** 第2颗牙BI的第2个值*//*
    @Column(name = "SND_BI_SND")
    String sndBiSnd;
    
    *//** 第3颗牙BI的第1个值*//*
    @Column(name = "TRD_BI_FST")
    String trdBiFst;
    
    *//** 第3颗牙BI的第2个值*//*
    @Column(name = "TRD_BI_SND")
    String trdBiSnd;
    
    *//** 第4颗牙BI的第1个值*//*
    @Column(name = "FOH_BI_FST")
    String fohBiFst;
    
    *//** 第4颗牙BI的第2个值*//*
    @Column(name = "FOH_BI_SND")
    String fohBiSnd;
    
    *//** 第5颗牙BI的第1个值*//*
    @Column(name = "FIH_BI_FST")
    String fihBiFst;
    
    *//** 第5颗牙BI的第2个值*//*
    @Column(name = "FIH_BI_SND")
    String fihBiSnd;
    
    *//** 第6颗牙BI的第1个值*//*
    @Column(name = "SIX_BI_FST")
    String sixBiFst;
    
    *//** 第6颗牙BI的第2个值*//*
    @Column(name = "SIX_BI_SND")
    String sixBiSnd;
    
    *//** 第7颗牙BI的第1个值*//*
    @Column(name = "SVN_BI_FST")
    String svnBiFst;
    
    *//** 第7颗牙BI的第2个值*//*
    @Column(name = "SVN_BI_SND")
    String svnBiSnd;
    
    *//** 第8颗牙BI的第1个值*//*
    @Column(name = "ETH_BI_FST")
    String ethBiFst;
    
    *//** 第8颗牙BI的第2个值*//*
    @Column(name = "ETH_BI_SND")
    String ethBiSnd;
    
    *//** 第1颗牙B的第1个值*//*
    @Column(name = "FST_PD_B_FST")
    String fstPdBFst;
    
    *//** 第1颗牙B的第2个值*//*
    @Column(name = "FST_PD_B_SND")
    String fstPdBSnd;
    
    *//** 第1颗牙B的第3个值*//*
    @Column(name = "FST_PD_B_TRD")
    String fstPdBTrd;
    
    *//** 第1颗牙B的第4个值*//*
    @Column(name = "FST_PD_B_FOH")
    String fstPdBFoh;
    
    *//** 第1颗牙B的第5个值*//*
    @Column(name = "FST_PD_B_FIH")
    String fstPdBFih;
    
    *//** 第1颗牙B的第6个值*//*
    @Column(name = "FST_PD_B_SIX")
    String fstPdBSix;
    
    *//** 第2颗牙B的第1个值*//*
    @Column(name = "SND_PD_B_FST")
    String sndPdBFst;
    
    *//** 第2颗牙B的第2个值*//*
    @Column(name = "SND_PD_B_SND")
    String sndPdBSnd;
    
    *//** 第2颗牙B的第3个值*//*
    @Column(name = "SND_PD_B_TRD")
    String sndPdBTrd;
    
    *//** 第2颗牙B的第4个值*//*
    @Column(name = "SND_PD_B_FOH")
    String sndPdBFoh;
    
    *//** 第2颗牙B的第5个值*//*
    @Column(name = "SND_PD_B_FIH")
    String sndPdBFih;
    
    *//** 第2颗牙B的第6个值*//*
    @Column(name = "SND_PD_B_SIX")
    String sndPdBSix;
    
    *//** 第3颗牙B的第1个值*//*
    @Column(name = "TRD_PD_B_FST")
    String trdPdBFst;
    
    *//** 第3颗牙B的第2个值*//*
    @Column(name = "TRD_PD_B_SND")
    String trdPdBSnd;
    
    *//** 第3颗牙B的第3个值*//*
    @Column(name = "TRD_PD_B_TRD")
    String trdPdBTrd;
    
    *//** 第3颗牙B的第4个值*//*
    @Column(name = "TRD_PD_B_FOH")
    String trdPdBFoh;
    
    *//** 第3颗牙B的第5个值*//*
    @Column(name = "TRD_PD_B_FIH")
    String trdPdBFih;
    
    *//** 第3颗牙B的第6个值*//*
    @Column(name = "TRD_PD_B_SIX")
    String trdPdBSix;
    
    *//** 第4颗牙B的第1个值*//*
    @Column(name = "FOH_PD_B_FST")
    String fohPdBFst;
    
    *//** 第4颗牙B的第2个值*//*
    @Column(name = "FOH_PD_B_SND")
    String fohPdBSnd;
    
    *//** 第4颗牙B的第3个值*//*
    @Column(name = "FOH_PD_B_TRD")
    String fohPdBTrd;
    
    *//** 第4颗牙B的第4个值*//*
    @Column(name = "FOH_PD_B_FOH")
    String fohPdBFoh;
    
    *//** 第4颗牙B的第5个值*//*
    @Column(name = "FOH_PD_B_FIH")
    String fohPdBFih;
    
    *//** 第4颗牙B的第6个值*//*
    @Column(name = "FOH_PD_B_SIX")
    String fohPdBSix;
    
    *//** 第5颗牙B的第1个值*//*
    @Column(name = "FIH_PD_B_FST")
    String fihPdBFst;
    
    *//** 第5颗牙B的第2个值*//*
    @Column(name = "FIH_PD_B_SND")
    String fihPdBSnd;
    
    *//** 第5颗牙B的第3个值*//*
    @Column(name = "FIH_PD_B_TRD")
    String fihPdBTrd;
    
    *//** 第5颗牙B的第4个值*//*
    @Column(name = "FIH_PD_B_FOH")
    String fihPdBFoh;
    
    *//** 第5颗牙B的第5个值*//*
    @Column(name = "FIH_PD_B_FIH")
    String fihPdBFih;
    
    *//** 第5颗牙B的第6个值*//*
    @Column(name = "FIH_PD_B_SIX")
    String fihPdBSix;
    
    *//** 第6颗牙B的第1个值*//*
    @Column(name = "SIX_PD_B_FST")
    String sixPdBFst;
    
    *//** 第6颗牙B的第2个值*//*
    @Column(name = "SIX_PD_B_SND")
    String sixPdBSnd;
    
    *//** 第6颗牙B的第3个值*//*
    @Column(name = "SIX_PD_B_TRD")
    String sixPdBTrd;
    
    *//** 第6颗牙B的第4个值*//*
    @Column(name = "SIX_PD_B_FOH")
    String sixPdBFoh;
    
    *//** 第6颗牙B的第5个值*//*
    @Column(name = "SIX_PD_B_FIH")
    String sixPdBFih;
    
    *//** 第6颗牙B的第6个值*//*
    @Column(name = "SIX_PD_B_SIX")
    String sixPdBSix;
    
    *//** 第7颗牙B的第1个值*//*
    @Column(name = "SVN_PD_B_FST")
    String svnPdBFst;
    
    *//** 第7颗牙B的第2个值*//*
    @Column(name = "SVN_PD_B_SND")
    String svnPdBSnd;
    
    *//** 第7颗牙B的第3个值*//*
    @Column(name = "SVN_PD_B_TRD")
    String svnPdBTrd;
    
    *//** 第7颗牙B的第4个值*//*
    @Column(name = "SVN_PD_B_FOH")
    String svnPdBFoh;
    
    *//** 第7颗牙B的第5个值*//*
    @Column(name = "SVN_PD_B_FIH")
    String svnPdBFih;
    
    *//** 第7颗牙B的第6个值*//*
    @Column(name = "SVN_PD_B_SIX")
    String svnPdBSix;
    
    *//** 第8颗牙B的第1个值*//*
    @Column(name = "ETH_PD_B_FST")
    String ethPdBFst;
    
    *//** 第8颗牙B的第2个值*//*
    @Column(name = "ETH_PD_B_SND")
    String ethPdBSnd;
    
    *//** 第8颗牙B的第3个值*//*
    @Column(name = "ETH_PD_B_TRD")
    String ethPdBTrd;
    
    *//** 第8颗牙B的第4个值*//*
    @Column(name = "ETH_PD_B_FOH")
    String ethPdBFoh;
    
    *//** 第8颗牙B的第5个值*//*
    @Column(name = "ETH_PD_B_FIH")
    String ethPdBFih;
    
    *//** 第8颗牙B的第6个值*//*
    @Column(name = "ETH_PD_B_SIX")
    String ethPdBSix;
    
    *//** 第1颗牙L的第1个值*//*
    @Column(name = "FST_PD_L_FST")
    String fstPdLFst;
    
    *//** 第1颗牙L的第2个值*//*
    @Column(name = "FST_PD_L_SND")
    String fstPdLSnd;
    
    *//** 第1颗牙L的第3个值*//*
    @Column(name = "FST_PD_L_TRD")
    String fstPdLTrd;
    
    *//** 第1颗牙L的第4个值*//*
    @Column(name = "FST_PD_L_FOH")
    String fstPdLFoh;
    
    *//** 第1颗牙L的第5个值*//*
    @Column(name = "FST_PD_L_FIH")
    String fstPdLFih;
    
    *//** 第1颗牙L的第6个值*//*
    @Column(name = "FST_PD_L_SIX")
    String fstPdLSix;
    
    *//** 第2颗牙L的第1个值*//*
    @Column(name = "SND_PD_L_FST")
    String sndPdLFst;
    
    *//** 第2颗牙L的第2个值*//*
    @Column(name = "SND_PD_L_SND")
    String sndPdLSnd;
    
    *//** 第2颗牙L的第3个值*//*
    @Column(name = "SND_PD_L_TRD")
    String sndPdLTrd;
    
    *//** 第2颗牙L的第4个值*//*
    @Column(name = "SND_PD_L_FOH")
    String sndPdLFoh;
    
    *//** 第2颗牙L的第5个值*//*
    @Column(name = "SND_PD_L_FIH")
    String sndPdLFih;
    
    *//** 第2颗牙L的第6个值*//*
    @Column(name = "SND_PD_L_SIX")
    String sndPdLSix;
    
    *//** 第3颗牙L的第1个值*//*
    @Column(name = "TRD_PD_L_FST")
    String trdPdLFst;
    
    *//** 第3颗牙L的第2个值*//*
    @Column(name = "TRD_PD_L_SND")
    String trdPdLSnd;
    
    *//** 第3颗牙L的第3个值*//*
    @Column(name = "TRD_PD_L_TRD")
    String trdPdLTrd;
    
    *//** 第3颗牙L的第4个值*//*
    @Column(name = "TRD_PD_L_FOH")
    String trdPdLFoh;
    
    *//** 第3颗牙L的第5个值*//*
    @Column(name = "TRD_PD_L_FIH")
    String trdPdLFih;
    
    *//** 第3颗牙L的第6个值*//*
    @Column(name = "TRD_PD_L_SIX")
    String trdPdLSix;
    
    *//** 第4颗牙L的第1个值*//*
    @Column(name = "FOH_PD_L_FST")
    String fohPdLFst;
    
    *//** 第4颗牙L的第2个值*//*
    @Column(name = "FOH_PD_L_SND")
    String fohPdLSnd;
    
    *//** 第4颗牙L的第3个值*//*
    @Column(name = "FOH_PD_L_TRD")
    String fohPdLTrd;
    
    *//** 第4颗牙L的第4个值*//*
    @Column(name = "FOH_PD_L_FOH")
    String fohPdLFoh;
    
    *//** 第4颗牙L的第5个值*//*
    @Column(name = "FOH_PD_L_FIH")
    String fohPdLFih;
    
    *//** 第4颗牙L的第6个值*//*
    @Column(name = "FOH_PD_L_SIX")
    String fohPdLSix;
    
    *//** 第5颗牙L的第1个值*//*
    @Column(name = "FIH_PD_L_FST")
    String fihPdLFst;
    
    *//** 第5颗牙L的第2个值*//*
    @Column(name = "FIH_PD_L_SND")
    String fihPdLSnd;
    
    *//** 第5颗牙L的第3个值*//*
    @Column(name = "FIH_PD_L_TRD")
    String fihPdLTrd;
    
    *//** 第5颗牙L的第4个值*//*
    @Column(name = "FIH_PD_L_FOH")
    String fihPdLFoh;
    
    *//** 第5颗牙L的第5个值*//*
    @Column(name = "FIH_PD_L_FIH")
    String fihPdLFih;
    
    *//** 第5颗牙L的第6个值*//*
    @Column(name = "FIH_PD_L_SIX")
    String fihPdLSix;
    
    *//** 第6颗牙L的第1个值*//*
    @Column(name = "SIX_PD_L_FST")
    String sixPdLFst;
    
    *//** 第6颗牙L的第2个值*//*
    @Column(name = "SIX_PD_L_SND")
    String sixPdLSnd;
    
    *//** 第6颗牙L的第3个值*//*
    @Column(name = "SIX_PD_L_TRD")
    String sixPdLTrd;
    
    *//** 第6颗牙L的第4个值*//*
    @Column(name = "SIX_PD_L_FOH")
    String sixPdLFoh;
    
    *//** 第6颗牙L的第5个值*//*
    @Column(name = "SIX_PD_L_FIH")
    String sixPdLFih;
    
    *//** 第6颗牙L的第6个值*//*
    @Column(name = "SIX_PD_L_SIX")
    String sixPdLSix;
    
    *//** 第7颗牙L的第1个值*//*
    @Column(name = "SVN_PD_L_FST")
    String svnPdLFst;
    
    *//** 第7颗牙L的第2个值*//*
    @Column(name = "SVN_PD_L_SND")
    String svnPdLSnd;
    
    *//** 第7颗牙L的第3个值*//*
    @Column(name = "SVN_PD_L_TRD")
    String svnPdLTrd;
    
    *//** 第7颗牙L的第4个值*//*
    @Column(name = "SVN_PD_L_FOH")
    String svnPdLFoh;
    
    *//** 第7颗牙L的第5个值*//*
    @Column(name = "SVN_PD_L_FIH")
    String svnPdLFih;
    
    *//** 第7颗牙L的第6个值*//*
    @Column(name = "SVN_PD_L_SIX")
    String svnPdLSix;
    
    *//** 第8颗牙L的第1个值*//*
    @Column(name = "ETH_PD_L_FST")
    String ethPdLFst;
    
    *//** 第8颗牙L的第2个值*//*
    @Column(name = "ETH_PD_L_SND")
    String ethPdLSnd;
    
    *//** 第8颗牙L的第3个值*//*
    @Column(name = "ETH_PD_L_TRD")
    String ethPdLTrd;
    
    *//** 第8颗牙L的第4个值*//*
    @Column(name = "ETH_PD_L_FOH")
    String ethPdLFoh;
    
    *//** 第8颗牙L的第5个值*//*
    @Column(name = "ETH_PD_L_FIH")
    String ethPdLFih;
    
    *//** 第8颗牙L的第6个值*//*
    @Column(name = "ETH_PD_L_SIX")
    String ethPdLSix;*/
    
    @Column(name = "VALUE_STR")
    String valueStr;
    
    @Column(name = "COL_DISABLED")
    String colDisabled;
    
    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    /** */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    Short delF;

    public String getTeethItemPk()
    {
        return teethItemPk;
    }

    public void setTeethItemPk(String teethItemPk)
    {
        this.teethItemPk = teethItemPk;
    }

    public String getTeethPk()
    {
        return teethPk;
    }

    public void setTeethPk(String teethPk)
    {
        this.teethPk = teethPk;
    }

    public String getTeethLocation()
    {
        return teethLocation;
    }

    public void setTeethLocation(String teethLocation)
    {
        this.teethLocation = teethLocation;
    }

    /*public String getFstFiFst()
    {
        return fstFiFst;
    }

    public void setFstFiFst(String fstFiFst)
    {
        this.fstFiFst = fstFiFst;
    }

    public String getFstFiSnd()
    {
        return fstFiSnd;
    }

    public void setFstFiSnd(String fstFiSnd)
    {
        this.fstFiSnd = fstFiSnd;
    }

    public String getFstFiTrd()
    {
        return fstFiTrd;
    }

    public void setFstFiTrd(String fstFiTrd)
    {
        this.fstFiTrd = fstFiTrd;
    }

    public String getSndFiFst()
    {
        return sndFiFst;
    }

    public void setSndFiFst(String sndFiFst)
    {
        this.sndFiFst = sndFiFst;
    }

    public String getSndFiSnd()
    {
        return sndFiSnd;
    }

    public void setSndFiSnd(String sndFiSnd)
    {
        this.sndFiSnd = sndFiSnd;
    }

    public String getSndFiTrd()
    {
        return sndFiTrd;
    }

    public void setSndFiTrd(String sndFiTrd)
    {
        this.sndFiTrd = sndFiTrd;
    }

    public String getTrdFiFst()
    {
        return trdFiFst;
    }

    public void setTrdFiFst(String trdFiFst)
    {
        this.trdFiFst = trdFiFst;
    }

    public String getTrdFiSnd()
    {
        return trdFiSnd;
    }

    public void setTrdFiSnd(String trdFiSnd)
    {
        this.trdFiSnd = trdFiSnd;
    }

    public String getTrdFiTrd()
    {
        return trdFiTrd;
    }

    public void setTrdFiTrd(String trdFiTrd)
    {
        this.trdFiTrd = trdFiTrd;
    }

    public String getFstKtFst()
    {
        return fstKtFst;
    }

    public void setFstKtFst(String fstKtFst)
    {
        this.fstKtFst = fstKtFst;
    }

    public String getFstKtSnd()
    {
        return fstKtSnd;
    }

    public void setFstKtSnd(String fstKtSnd)
    {
        this.fstKtSnd = fstKtSnd;
    }

    public String getFstKtTrd()
    {
        return fstKtTrd;
    }

    public void setFstKtTrd(String fstKtTrd)
    {
        this.fstKtTrd = fstKtTrd;
    }

    public String getFstKtFoh()
    {
        return fstKtFoh;
    }

    public void setFstKtFoh(String fstKtFoh)
    {
        this.fstKtFoh = fstKtFoh;
    }

    public String getFstKtFih()
    {
        return fstKtFih;
    }

    public void setFstKtFih(String fstKtFih)
    {
        this.fstKtFih = fstKtFih;
    }

    public String getFstKtSix()
    {
        return fstKtSix;
    }

    public void setFstKtSix(String fstKtSix)
    {
        this.fstKtSix = fstKtSix;
    }

    public String getSndKtFst()
    {
        return sndKtFst;
    }

    public void setSndKtFst(String sndKtFst)
    {
        this.sndKtFst = sndKtFst;
    }

    public String getSndKtSnd()
    {
        return sndKtSnd;
    }

    public void setSndKtSnd(String sndKtSnd)
    {
        this.sndKtSnd = sndKtSnd;
    }

    public String getSndKtTrd()
    {
        return sndKtTrd;
    }

    public void setSndKtTrd(String sndKtTrd)
    {
        this.sndKtTrd = sndKtTrd;
    }

    public String getSndKtFoh()
    {
        return sndKtFoh;
    }

    public void setSndKtFoh(String sndKtFoh)
    {
        this.sndKtFoh = sndKtFoh;
    }

    public String getSndKtFih()
    {
        return sndKtFih;
    }

    public void setSndKtFih(String sndKtFih)
    {
        this.sndKtFih = sndKtFih;
    }

    public String getSndKtSix()
    {
        return sndKtSix;
    }

    public void setSndKtSix(String sndKtSix)
    {
        this.sndKtSix = sndKtSix;
    }

    public String getTrdKtFst()
    {
        return trdKtFst;
    }

    public void setTrdKtFst(String trdKtFst)
    {
        this.trdKtFst = trdKtFst;
    }

    public String getTrdKtSnd()
    {
        return trdKtSnd;
    }

    public void setTrdKtSnd(String trdKtSnd)
    {
        this.trdKtSnd = trdKtSnd;
    }

    public String getTrdKtTrd()
    {
        return trdKtTrd;
    }

    public void setTrdKtTrd(String trdKtTrd)
    {
        this.trdKtTrd = trdKtTrd;
    }

    public String getTrdKtFoh()
    {
        return trdKtFoh;
    }

    public void setTrdKtFoh(String trdKtFoh)
    {
        this.trdKtFoh = trdKtFoh;
    }

    public String getTrdKtFih()
    {
        return trdKtFih;
    }

    public void setTrdKtFih(String trdKtFih)
    {
        this.trdKtFih = trdKtFih;
    }

    public String getTrdKtSix()
    {
        return trdKtSix;
    }

    public void setTrdKtSix(String trdKtSix)
    {
        this.trdKtSix = trdKtSix;
    }

    public String getFohKtFst()
    {
        return fohKtFst;
    }

    public void setFohKtFst(String fohKtFst)
    {
        this.fohKtFst = fohKtFst;
    }

    public String getFohKtSnd()
    {
        return fohKtSnd;
    }

    public void setFohKtSnd(String fohKtSnd)
    {
        this.fohKtSnd = fohKtSnd;
    }

    public String getFohKtTrd()
    {
        return fohKtTrd;
    }

    public void setFohKtTrd(String fohKtTrd)
    {
        this.fohKtTrd = fohKtTrd;
    }

    public String getFohKtFoh()
    {
        return fohKtFoh;
    }

    public void setFohKtFoh(String fohKtFoh)
    {
        this.fohKtFoh = fohKtFoh;
    }

    public String getFohKtFih()
    {
        return fohKtFih;
    }

    public void setFohKtFih(String fohKtFih)
    {
        this.fohKtFih = fohKtFih;
    }

    public String getFohKtSix()
    {
        return fohKtSix;
    }

    public void setFohKtSix(String fohKtSix)
    {
        this.fohKtSix = fohKtSix;
    }

    public String getFihKtFst()
    {
        return fihKtFst;
    }

    public void setFihKtFst(String fihKtFst)
    {
        this.fihKtFst = fihKtFst;
    }

    public String getFihKtSnd()
    {
        return fihKtSnd;
    }

    public void setFihKtSnd(String fihKtSnd)
    {
        this.fihKtSnd = fihKtSnd;
    }

    public String getFihKtTrd()
    {
        return fihKtTrd;
    }

    public void setFihKtTrd(String fihKtTrd)
    {
        this.fihKtTrd = fihKtTrd;
    }

    public String getFihKtFoh()
    {
        return fihKtFoh;
    }

    public void setFihKtFoh(String fihKtFoh)
    {
        this.fihKtFoh = fihKtFoh;
    }

    public String getFihKtFih()
    {
        return fihKtFih;
    }

    public void setFihKtFih(String fihKtFih)
    {
        this.fihKtFih = fihKtFih;
    }

    public String getFihKtSix()
    {
        return fihKtSix;
    }

    public void setFihKtSix(String fihKtSix)
    {
        this.fihKtSix = fihKtSix;
    }

    public String getSixKtFst()
    {
        return sixKtFst;
    }

    public void setSixKtFst(String sixKtFst)
    {
        this.sixKtFst = sixKtFst;
    }

    public String getSixKtSnd()
    {
        return sixKtSnd;
    }

    public void setSixKtSnd(String sixKtSnd)
    {
        this.sixKtSnd = sixKtSnd;
    }

    public String getSixKtTrd()
    {
        return sixKtTrd;
    }

    public void setSixKtTrd(String sixKtTrd)
    {
        this.sixKtTrd = sixKtTrd;
    }

    public String getSixKtFoh()
    {
        return sixKtFoh;
    }

    public void setSixKtFoh(String sixKtFoh)
    {
        this.sixKtFoh = sixKtFoh;
    }

    public String getSixKtFih()
    {
        return sixKtFih;
    }

    public void setSixKtFih(String sixKtFih)
    {
        this.sixKtFih = sixKtFih;
    }

    public String getSixKtSix()
    {
        return sixKtSix;
    }

    public void setSixKtSix(String sixKtSix)
    {
        this.sixKtSix = sixKtSix;
    }

    public String getSvnKtFst()
    {
        return svnKtFst;
    }

    public void setSvnKtFst(String svnKtFst)
    {
        this.svnKtFst = svnKtFst;
    }

    public String getSvnKtSnd()
    {
        return svnKtSnd;
    }

    public void setSvnKtSnd(String svnKtSnd)
    {
        this.svnKtSnd = svnKtSnd;
    }

    public String getSvnKtTrd()
    {
        return svnKtTrd;
    }

    public void setSvnKtTrd(String svnKtTrd)
    {
        this.svnKtTrd = svnKtTrd;
    }

    public String getSvnKtFoh()
    {
        return svnKtFoh;
    }

    public void setSvnKtFoh(String svnKtFoh)
    {
        this.svnKtFoh = svnKtFoh;
    }

    public String getSvnKtFih()
    {
        return svnKtFih;
    }

    public void setSvnKtFih(String svnKtFih)
    {
        this.svnKtFih = svnKtFih;
    }

    public String getSvnKtSix()
    {
        return svnKtSix;
    }

    public void setSvnKtSix(String svnKtSix)
    {
        this.svnKtSix = svnKtSix;
    }

    public String getEthKtFst()
    {
        return ethKtFst;
    }

    public void setEthKtFst(String ethKtFst)
    {
        this.ethKtFst = ethKtFst;
    }

    public String getEthKtSnd()
    {
        return ethKtSnd;
    }

    public void setEthKtSnd(String ethKtSnd)
    {
        this.ethKtSnd = ethKtSnd;
    }

    public String getEthKtTrd()
    {
        return ethKtTrd;
    }

    public void setEthKtTrd(String ethKtTrd)
    {
        this.ethKtTrd = ethKtTrd;
    }

    public String getEthKtFoh()
    {
        return ethKtFoh;
    }

    public void setEthKtFoh(String ethKtFoh)
    {
        this.ethKtFoh = ethKtFoh;
    }

    public String getEthKtFih()
    {
        return ethKtFih;
    }

    public void setEthKtFih(String ethKtFih)
    {
        this.ethKtFih = ethKtFih;
    }

    public String getEthKtSix()
    {
        return ethKtSix;
    }

    public void setEthKtSix(String ethKtSix)
    {
        this.ethKtSix = ethKtSix;
    }

    public String getFstOpFst()
    {
        return fstOpFst;
    }

    public void setFstOpFst(String fstOpFst)
    {
        this.fstOpFst = fstOpFst;
    }

    public String getFstOpSnd()
    {
        return fstOpSnd;
    }

    public void setFstOpSnd(String fstOpSnd)
    {
        this.fstOpSnd = fstOpSnd;
    }

    public String getSndOpFst()
    {
        return sndOpFst;
    }

    public void setSndOpFst(String sndOpFst)
    {
        this.sndOpFst = sndOpFst;
    }

    public String getSndOpSnd()
    {
        return sndOpSnd;
    }

    public void setSndOpSnd(String sndOpSnd)
    {
        this.sndOpSnd = sndOpSnd;
    }

    public String getTrdOpFst()
    {
        return trdOpFst;
    }

    public void setTrdOpFst(String trdOpFst)
    {
        this.trdOpFst = trdOpFst;
    }

    public String getTrdOpSnd()
    {
        return trdOpSnd;
    }

    public void setTrdOpSnd(String trdOpSnd)
    {
        this.trdOpSnd = trdOpSnd;
    }

    public String getFohOpFst()
    {
        return fohOpFst;
    }

    public void setFohOpFst(String fohOpFst)
    {
        this.fohOpFst = fohOpFst;
    }

    public String getFohOpSnd()
    {
        return fohOpSnd;
    }

    public void setFohOpSnd(String fohOpSnd)
    {
        this.fohOpSnd = fohOpSnd;
    }

    public String getFihOpFst()
    {
        return fihOpFst;
    }

    public void setFihOpFst(String fihOpFst)
    {
        this.fihOpFst = fihOpFst;
    }

    public String getFihOpSnd()
    {
        return fihOpSnd;
    }

    public void setFihOpSnd(String fihOpSnd)
    {
        this.fihOpSnd = fihOpSnd;
    }

    public String getSixOpFst()
    {
        return sixOpFst;
    }

    public void setSixOpFst(String sixOpFst)
    {
        this.sixOpFst = sixOpFst;
    }

    public String getSixOpSnd()
    {
        return sixOpSnd;
    }

    public void setSixOpSnd(String sixOpSnd)
    {
        this.sixOpSnd = sixOpSnd;
    }

    public String getSvnOpFst()
    {
        return svnOpFst;
    }

    public void setSvnOpFst(String svnOpFst)
    {
        this.svnOpFst = svnOpFst;
    }

    public String getSvnOpSnd()
    {
        return svnOpSnd;
    }

    public void setSvnOpSnd(String svnOpSnd)
    {
        this.svnOpSnd = svnOpSnd;
    }

    public String getEthOpFst()
    {
        return ethOpFst;
    }

    public void setEthOpFst(String ethOpFst)
    {
        this.ethOpFst = ethOpFst;
    }

    public String getEthOpSnd()
    {
        return ethOpSnd;
    }

    public void setEthOpSnd(String ethOpSnd)
    {
        this.ethOpSnd = ethOpSnd;
    }

    public String getFstMbFst()
    {
        return fstMbFst;
    }

    public void setFstMbFst(String fstMbFst)
    {
        this.fstMbFst = fstMbFst;
    }

    public String getFstMbSnd()
    {
        return fstMbSnd;
    }

    public void setFstMbSnd(String fstMbSnd)
    {
        this.fstMbSnd = fstMbSnd;
    }

    public String getSndMbFst()
    {
        return sndMbFst;
    }

    public void setSndMbFst(String sndMbFst)
    {
        this.sndMbFst = sndMbFst;
    }

    public String getSndMbSnd()
    {
        return sndMbSnd;
    }

    public void setSndMbSnd(String sndMbSnd)
    {
        this.sndMbSnd = sndMbSnd;
    }

    public String getTrdMbFst()
    {
        return trdMbFst;
    }

    public void setTrdMbFst(String trdMbFst)
    {
        this.trdMbFst = trdMbFst;
    }

    public String getTrdMbSnd()
    {
        return trdMbSnd;
    }

    public void setTrdMbSnd(String trdMbSnd)
    {
        this.trdMbSnd = trdMbSnd;
    }

    public String getFohMbFst()
    {
        return fohMbFst;
    }

    public void setFohMbFst(String fohMbFst)
    {
        this.fohMbFst = fohMbFst;
    }

    public String getFohMbSnd()
    {
        return fohMbSnd;
    }

    public void setFohMbSnd(String fohMbSnd)
    {
        this.fohMbSnd = fohMbSnd;
    }

    public String getFihMbFst()
    {
        return fihMbFst;
    }

    public void setFihMbFst(String fihMbFst)
    {
        this.fihMbFst = fihMbFst;
    }

    public String getFihMbSnd()
    {
        return fihMbSnd;
    }

    public void setFihMbSnd(String fihMbSnd)
    {
        this.fihMbSnd = fihMbSnd;
    }

    public String getSixMbFst()
    {
        return sixMbFst;
    }

    public void setSixMbFst(String sixMbFst)
    {
        this.sixMbFst = sixMbFst;
    }

    public String getSixMbSnd()
    {
        return sixMbSnd;
    }

    public void setSixMbSnd(String sixMbSnd)
    {
        this.sixMbSnd = sixMbSnd;
    }

    public String getSvnMbFst()
    {
        return svnMbFst;
    }

    public void setSvnMbFst(String svnMbFst)
    {
        this.svnMbFst = svnMbFst;
    }

    public String getSvnMbSnd()
    {
        return svnMbSnd;
    }

    public void setSvnMbSnd(String svnMbSnd)
    {
        this.svnMbSnd = svnMbSnd;
    }

    public String getEthMbFst()
    {
        return ethMbFst;
    }

    public void setEthMbFst(String ethMbFst)
    {
        this.ethMbFst = ethMbFst;
    }

    public String getEthMbSnd()
    {
        return ethMbSnd;
    }

    public void setEthMbSnd(String ethMbSnd)
    {
        this.ethMbSnd = ethMbSnd;
    }

    public String getFstPliFst()
    {
        return fstPliFst;
    }

    public void setFstPliFst(String fstPliFst)
    {
        this.fstPliFst = fstPliFst;
    }

    public String getFstPliSnd()
    {
        return fstPliSnd;
    }

    public void setFstPliSnd(String fstPliSnd)
    {
        this.fstPliSnd = fstPliSnd;
    }

    public String getFstPliTrd()
    {
        return fstPliTrd;
    }

    public void setFstPliTrd(String fstPliTrd)
    {
        this.fstPliTrd = fstPliTrd;
    }

    public String getFstPliFoh()
    {
        return fstPliFoh;
    }

    public void setFstPliFoh(String fstPliFoh)
    {
        this.fstPliFoh = fstPliFoh;
    }

    public String getFstPliFih()
    {
        return fstPliFih;
    }

    public void setFstPliFih(String fstPliFih)
    {
        this.fstPliFih = fstPliFih;
    }

    public String getFstPliSix()
    {
        return fstPliSix;
    }

    public void setFstPliSix(String fstPliSix)
    {
        this.fstPliSix = fstPliSix;
    }

    public String getSndPliFst()
    {
        return sndPliFst;
    }

    public void setSndPliFst(String sndPliFst)
    {
        this.sndPliFst = sndPliFst;
    }

    public String getSndPliSnd()
    {
        return sndPliSnd;
    }

    public void setSndPliSnd(String sndPliSnd)
    {
        this.sndPliSnd = sndPliSnd;
    }

    public String getSndPliTrd()
    {
        return sndPliTrd;
    }

    public void setSndPliTrd(String sndPliTrd)
    {
        this.sndPliTrd = sndPliTrd;
    }

    public String getSndPliFoh()
    {
        return sndPliFoh;
    }

    public void setSndPliFoh(String sndPliFoh)
    {
        this.sndPliFoh = sndPliFoh;
    }

    public String getSndPliFih()
    {
        return sndPliFih;
    }

    public void setSndPliFih(String sndPliFih)
    {
        this.sndPliFih = sndPliFih;
    }

    public String getSndPliSix()
    {
        return sndPliSix;
    }

    public void setSndPliSix(String sndPliSix)
    {
        this.sndPliSix = sndPliSix;
    }

    public String getTrdPliFst()
    {
        return trdPliFst;
    }

    public void setTrdPliFst(String trdPliFst)
    {
        this.trdPliFst = trdPliFst;
    }

    public String getTrdPliSnd()
    {
        return trdPliSnd;
    }

    public void setTrdPliSnd(String trdPliSnd)
    {
        this.trdPliSnd = trdPliSnd;
    }

    public String getTrdPliTrd()
    {
        return trdPliTrd;
    }

    public void setTrdPliTrd(String trdPliTrd)
    {
        this.trdPliTrd = trdPliTrd;
    }

    public String getTrdPliFoh()
    {
        return trdPliFoh;
    }

    public void setTrdPliFoh(String trdPliFoh)
    {
        this.trdPliFoh = trdPliFoh;
    }

    public String getTrdPliFih()
    {
        return trdPliFih;
    }

    public void setTrdPliFih(String trdPliFih)
    {
        this.trdPliFih = trdPliFih;
    }

    public String getTrdPliSix()
    {
        return trdPliSix;
    }

    public void setTrdPliSix(String trdPliSix)
    {
        this.trdPliSix = trdPliSix;
    }

    public String getFohPliFst()
    {
        return fohPliFst;
    }

    public void setFohPliFst(String fohPliFst)
    {
        this.fohPliFst = fohPliFst;
    }

    public String getFohPliSnd()
    {
        return fohPliSnd;
    }

    public void setFohPliSnd(String fohPliSnd)
    {
        this.fohPliSnd = fohPliSnd;
    }

    public String getFohPliTrd()
    {
        return fohPliTrd;
    }

    public void setFohPliTrd(String fohPliTrd)
    {
        this.fohPliTrd = fohPliTrd;
    }

    public String getFohPliFoh()
    {
        return fohPliFoh;
    }

    public void setFohPliFoh(String fohPliFoh)
    {
        this.fohPliFoh = fohPliFoh;
    }

    public String getFohPliFih()
    {
        return fohPliFih;
    }

    public void setFohPliFih(String fohPliFih)
    {
        this.fohPliFih = fohPliFih;
    }

    public String getFohPliSix()
    {
        return fohPliSix;
    }

    public void setFohPliSix(String fohPliSix)
    {
        this.fohPliSix = fohPliSix;
    }

    public String getFihPliFst()
    {
        return fihPliFst;
    }

    public void setFihPliFst(String fihPliFst)
    {
        this.fihPliFst = fihPliFst;
    }

    public String getFihPliSnd()
    {
        return fihPliSnd;
    }

    public void setFihPliSnd(String fihPliSnd)
    {
        this.fihPliSnd = fihPliSnd;
    }

    public String getFihPliTrd()
    {
        return fihPliTrd;
    }

    public void setFihPliTrd(String fihPliTrd)
    {
        this.fihPliTrd = fihPliTrd;
    }

    public String getFihPliFoh()
    {
        return fihPliFoh;
    }

    public void setFihPliFoh(String fihPliFoh)
    {
        this.fihPliFoh = fihPliFoh;
    }

    public String getFihPliFih()
    {
        return fihPliFih;
    }

    public void setFihPliFih(String fihPliFih)
    {
        this.fihPliFih = fihPliFih;
    }

    public String getFihPliSix()
    {
        return fihPliSix;
    }

    public void setFihPliSix(String fihPliSix)
    {
        this.fihPliSix = fihPliSix;
    }

    public String getSixPliFst()
    {
        return sixPliFst;
    }

    public void setSixPliFst(String sixPliFst)
    {
        this.sixPliFst = sixPliFst;
    }

    public String getSixPliSnd()
    {
        return sixPliSnd;
    }

    public void setSixPliSnd(String sixPliSnd)
    {
        this.sixPliSnd = sixPliSnd;
    }

    public String getSixPliTrd()
    {
        return sixPliTrd;
    }

    public void setSixPliTrd(String sixPliTrd)
    {
        this.sixPliTrd = sixPliTrd;
    }

    public String getSixPliFoh()
    {
        return sixPliFoh;
    }

    public void setSixPliFoh(String sixPliFoh)
    {
        this.sixPliFoh = sixPliFoh;
    }

    public String getSixPliFih()
    {
        return sixPliFih;
    }

    public void setSixPliFih(String sixPliFih)
    {
        this.sixPliFih = sixPliFih;
    }

    public String getSixPliSix()
    {
        return sixPliSix;
    }

    public void setSixPliSix(String sixPliSix)
    {
        this.sixPliSix = sixPliSix;
    }

    public String getSvnPliFst()
    {
        return svnPliFst;
    }

    public void setSvnPliFst(String svnPliFst)
    {
        this.svnPliFst = svnPliFst;
    }

    public String getSvnPliSnd()
    {
        return svnPliSnd;
    }

    public void setSvnPliSnd(String svnPliSnd)
    {
        this.svnPliSnd = svnPliSnd;
    }

    public String getSvnPliTrd()
    {
        return svnPliTrd;
    }

    public void setSvnPliTrd(String svnPliTrd)
    {
        this.svnPliTrd = svnPliTrd;
    }

    public String getSvnPliFoh()
    {
        return svnPliFoh;
    }

    public void setSvnPliFoh(String svnPliFoh)
    {
        this.svnPliFoh = svnPliFoh;
    }

    public String getSvnPliFih()
    {
        return svnPliFih;
    }

    public void setSvnPliFih(String svnPliFih)
    {
        this.svnPliFih = svnPliFih;
    }

    public String getSvnPliSix()
    {
        return svnPliSix;
    }

    public void setSvnPliSix(String svnPliSix)
    {
        this.svnPliSix = svnPliSix;
    }

    public String getEthPliFst()
    {
        return ethPliFst;
    }

    public void setEthPliFst(String ethPliFst)
    {
        this.ethPliFst = ethPliFst;
    }

    public String getEthPliSnd()
    {
        return ethPliSnd;
    }

    public void setEthPliSnd(String ethPliSnd)
    {
        this.ethPliSnd = ethPliSnd;
    }

    public String getEthPliTrd()
    {
        return ethPliTrd;
    }

    public void setEthPliTrd(String ethPliTrd)
    {
        this.ethPliTrd = ethPliTrd;
    }

    public String getEthPliFoh()
    {
        return ethPliFoh;
    }

    public void setEthPliFoh(String ethPliFoh)
    {
        this.ethPliFoh = ethPliFoh;
    }

    public String getEthPliFih()
    {
        return ethPliFih;
    }

    public void setEthPliFih(String ethPliFih)
    {
        this.ethPliFih = ethPliFih;
    }

    public String getEthPliSix()
    {
        return ethPliSix;
    }

    public void setEthPliSix(String ethPliSix)
    {
        this.ethPliSix = ethPliSix;
    }

    public String getFstCejFst()
    {
        return fstCejFst;
    }

    public void setFstCejFst(String fstCejFst)
    {
        this.fstCejFst = fstCejFst;
    }

    public String getFstCejSnd()
    {
        return fstCejSnd;
    }

    public void setFstCejSnd(String fstCejSnd)
    {
        this.fstCejSnd = fstCejSnd;
    }

    public String getSndCejFst()
    {
        return sndCejFst;
    }

    public void setSndCejFst(String sndCejFst)
    {
        this.sndCejFst = sndCejFst;
    }

    public String getSndCejSnd()
    {
        return sndCejSnd;
    }

    public void setSndCejSnd(String sndCejSnd)
    {
        this.sndCejSnd = sndCejSnd;
    }

    public String getTrdCejFst()
    {
        return trdCejFst;
    }

    public void setTrdCejFst(String trdCejFst)
    {
        this.trdCejFst = trdCejFst;
    }

    public String getTrdCejSnd()
    {
        return trdCejSnd;
    }

    public void setTrdCejSnd(String trdCejSnd)
    {
        this.trdCejSnd = trdCejSnd;
    }

    public String getFohCejFst()
    {
        return fohCejFst;
    }

    public void setFohCejFst(String fohCejFst)
    {
        this.fohCejFst = fohCejFst;
    }

    public String getFohCejSnd()
    {
        return fohCejSnd;
    }

    public void setFohCejSnd(String fohCejSnd)
    {
        this.fohCejSnd = fohCejSnd;
    }

    public String getFihCejFst()
    {
        return fihCejFst;
    }

    public void setFihCejFst(String fihCejFst)
    {
        this.fihCejFst = fihCejFst;
    }

    public String getFihCejSnd()
    {
        return fihCejSnd;
    }

    public void setFihCejSnd(String fihCejSnd)
    {
        this.fihCejSnd = fihCejSnd;
    }

    public String getSixCejFst()
    {
        return sixCejFst;
    }

    public void setSixCejFst(String sixCejFst)
    {
        this.sixCejFst = sixCejFst;
    }

    public String getSixCejSnd()
    {
        return sixCejSnd;
    }

    public void setSixCejSnd(String sixCejSnd)
    {
        this.sixCejSnd = sixCejSnd;
    }

    public String getSvnCejFst()
    {
        return svnCejFst;
    }

    public void setSvnCejFst(String svnCejFst)
    {
        this.svnCejFst = svnCejFst;
    }

    public String getSvnCejSnd()
    {
        return svnCejSnd;
    }

    public void setSvnCejSnd(String svnCejSnd)
    {
        this.svnCejSnd = svnCejSnd;
    }

    public String getEthCejFst()
    {
        return ethCejFst;
    }

    public void setEthCejFst(String ethCejFst)
    {
        this.ethCejFst = ethCejFst;
    }

    public String getEthCejSnd()
    {
        return ethCejSnd;
    }

    public void setEthCejSnd(String ethCejSnd)
    {
        this.ethCejSnd = ethCejSnd;
    }

    public String getFstBiFst()
    {
        return fstBiFst;
    }

    public void setFstBiFst(String fstBiFst)
    {
        this.fstBiFst = fstBiFst;
    }

    public String getFstBiSnd()
    {
        return fstBiSnd;
    }

    public void setFstBiSnd(String fstBiSnd)
    {
        this.fstBiSnd = fstBiSnd;
    }

    public String getSndBiFst()
    {
        return sndBiFst;
    }

    public void setSndBiFst(String sndBiFst)
    {
        this.sndBiFst = sndBiFst;
    }

    public String getSndBiSnd()
    {
        return sndBiSnd;
    }

    public void setSndBiSnd(String sndBiSnd)
    {
        this.sndBiSnd = sndBiSnd;
    }

    public String getTrdBiFst()
    {
        return trdBiFst;
    }

    public void setTrdBiFst(String trdBiFst)
    {
        this.trdBiFst = trdBiFst;
    }

    public String getTrdBiSnd()
    {
        return trdBiSnd;
    }

    public void setTrdBiSnd(String trdBiSnd)
    {
        this.trdBiSnd = trdBiSnd;
    }

    public String getFohBiFst()
    {
        return fohBiFst;
    }

    public void setFohBiFst(String fohBiFst)
    {
        this.fohBiFst = fohBiFst;
    }

    public String getFohBiSnd()
    {
        return fohBiSnd;
    }

    public void setFohBiSnd(String fohBiSnd)
    {
        this.fohBiSnd = fohBiSnd;
    }

    public String getFihBiFst()
    {
        return fihBiFst;
    }

    public void setFihBiFst(String fihBiFst)
    {
        this.fihBiFst = fihBiFst;
    }

    public String getFihBiSnd()
    {
        return fihBiSnd;
    }

    public void setFihBiSnd(String fihBiSnd)
    {
        this.fihBiSnd = fihBiSnd;
    }

    public String getSixBiFst()
    {
        return sixBiFst;
    }

    public void setSixBiFst(String sixBiFst)
    {
        this.sixBiFst = sixBiFst;
    }

    public String getSixBiSnd()
    {
        return sixBiSnd;
    }

    public void setSixBiSnd(String sixBiSnd)
    {
        this.sixBiSnd = sixBiSnd;
    }

    public String getSvnBiFst()
    {
        return svnBiFst;
    }

    public void setSvnBiFst(String svnBiFst)
    {
        this.svnBiFst = svnBiFst;
    }

    public String getSvnBiSnd()
    {
        return svnBiSnd;
    }

    public void setSvnBiSnd(String svnBiSnd)
    {
        this.svnBiSnd = svnBiSnd;
    }

    public String getEthBiFst()
    {
        return ethBiFst;
    }

    public void setEthBiFst(String ethBiFst)
    {
        this.ethBiFst = ethBiFst;
    }

    public String getEthBiSnd()
    {
        return ethBiSnd;
    }

    public void setEthBiSnd(String ethBiSnd)
    {
        this.ethBiSnd = ethBiSnd;
    }

    public String getFstPdBFst()
    {
        return fstPdBFst;
    }

    public void setFstPdBFst(String fstPdBFst)
    {
        this.fstPdBFst = fstPdBFst;
    }

    public String getFstPdBSnd()
    {
        return fstPdBSnd;
    }

    public void setFstPdBSnd(String fstPdBSnd)
    {
        this.fstPdBSnd = fstPdBSnd;
    }

    public String getFstPdBTrd()
    {
        return fstPdBTrd;
    }

    public void setFstPdBTrd(String fstPdBTrd)
    {
        this.fstPdBTrd = fstPdBTrd;
    }

    public String getFstPdBFoh()
    {
        return fstPdBFoh;
    }

    public void setFstPdBFoh(String fstPdBFoh)
    {
        this.fstPdBFoh = fstPdBFoh;
    }

    public String getFstPdBFih()
    {
        return fstPdBFih;
    }

    public void setFstPdBFih(String fstPdBFih)
    {
        this.fstPdBFih = fstPdBFih;
    }

    public String getFstPdBSix()
    {
        return fstPdBSix;
    }

    public void setFstPdBSix(String fstPdBSix)
    {
        this.fstPdBSix = fstPdBSix;
    }

    public String getSndPdBFst()
    {
        return sndPdBFst;
    }

    public void setSndPdBFst(String sndPdBFst)
    {
        this.sndPdBFst = sndPdBFst;
    }

    public String getSndPdBSnd()
    {
        return sndPdBSnd;
    }

    public void setSndPdBSnd(String sndPdBSnd)
    {
        this.sndPdBSnd = sndPdBSnd;
    }

    public String getSndPdBTrd()
    {
        return sndPdBTrd;
    }

    public void setSndPdBTrd(String sndPdBTrd)
    {
        this.sndPdBTrd = sndPdBTrd;
    }

    public String getSndPdBFoh()
    {
        return sndPdBFoh;
    }

    public void setSndPdBFoh(String sndPdBFoh)
    {
        this.sndPdBFoh = sndPdBFoh;
    }

    public String getSndPdBFih()
    {
        return sndPdBFih;
    }

    public void setSndPdBFih(String sndPdBFih)
    {
        this.sndPdBFih = sndPdBFih;
    }

    public String getSndPdBSix()
    {
        return sndPdBSix;
    }

    public void setSndPdBSix(String sndPdBSix)
    {
        this.sndPdBSix = sndPdBSix;
    }

    public String getTrdPdBFst()
    {
        return trdPdBFst;
    }

    public void setTrdPdBFst(String trdPdBFst)
    {
        this.trdPdBFst = trdPdBFst;
    }

    public String getTrdPdBSnd()
    {
        return trdPdBSnd;
    }

    public void setTrdPdBSnd(String trdPdBSnd)
    {
        this.trdPdBSnd = trdPdBSnd;
    }

    public String getTrdPdBTrd()
    {
        return trdPdBTrd;
    }

    public void setTrdPdBTrd(String trdPdBTrd)
    {
        this.trdPdBTrd = trdPdBTrd;
    }

    public String getTrdPdBFoh()
    {
        return trdPdBFoh;
    }

    public void setTrdPdBFoh(String trdPdBFoh)
    {
        this.trdPdBFoh = trdPdBFoh;
    }

    public String getTrdPdBFih()
    {
        return trdPdBFih;
    }

    public void setTrdPdBFih(String trdPdBFih)
    {
        this.trdPdBFih = trdPdBFih;
    }

    public String getTrdPdBSix()
    {
        return trdPdBSix;
    }

    public void setTrdPdBSix(String trdPdBSix)
    {
        this.trdPdBSix = trdPdBSix;
    }

    public String getFohPdBFst()
    {
        return fohPdBFst;
    }

    public void setFohPdBFst(String fohPdBFst)
    {
        this.fohPdBFst = fohPdBFst;
    }

    public String getFohPdBSnd()
    {
        return fohPdBSnd;
    }

    public void setFohPdBSnd(String fohPdBSnd)
    {
        this.fohPdBSnd = fohPdBSnd;
    }

    public String getFohPdBTrd()
    {
        return fohPdBTrd;
    }

    public void setFohPdBTrd(String fohPdBTrd)
    {
        this.fohPdBTrd = fohPdBTrd;
    }

    public String getFohPdBFoh()
    {
        return fohPdBFoh;
    }

    public void setFohPdBFoh(String fohPdBFoh)
    {
        this.fohPdBFoh = fohPdBFoh;
    }

    public String getFohPdBFih()
    {
        return fohPdBFih;
    }

    public void setFohPdBFih(String fohPdBFih)
    {
        this.fohPdBFih = fohPdBFih;
    }

    public String getFohPdBSix()
    {
        return fohPdBSix;
    }

    public void setFohPdBSix(String fohPdBSix)
    {
        this.fohPdBSix = fohPdBSix;
    }

    public String getFihPdBFst()
    {
        return fihPdBFst;
    }

    public void setFihPdBFst(String fihPdBFst)
    {
        this.fihPdBFst = fihPdBFst;
    }

    public String getFihPdBSnd()
    {
        return fihPdBSnd;
    }

    public void setFihPdBSnd(String fihPdBSnd)
    {
        this.fihPdBSnd = fihPdBSnd;
    }

    public String getFihPdBTrd()
    {
        return fihPdBTrd;
    }

    public void setFihPdBTrd(String fihPdBTrd)
    {
        this.fihPdBTrd = fihPdBTrd;
    }

    public String getFihPdBFoh()
    {
        return fihPdBFoh;
    }

    public void setFihPdBFoh(String fihPdBFoh)
    {
        this.fihPdBFoh = fihPdBFoh;
    }

    public String getFihPdBFih()
    {
        return fihPdBFih;
    }

    public void setFihPdBFih(String fihPdBFih)
    {
        this.fihPdBFih = fihPdBFih;
    }

    public String getFihPdBSix()
    {
        return fihPdBSix;
    }

    public void setFihPdBSix(String fihPdBSix)
    {
        this.fihPdBSix = fihPdBSix;
    }

    public String getSixPdBFst()
    {
        return sixPdBFst;
    }

    public void setSixPdBFst(String sixPdBFst)
    {
        this.sixPdBFst = sixPdBFst;
    }

    public String getSixPdBSnd()
    {
        return sixPdBSnd;
    }

    public void setSixPdBSnd(String sixPdBSnd)
    {
        this.sixPdBSnd = sixPdBSnd;
    }

    public String getSixPdBTrd()
    {
        return sixPdBTrd;
    }

    public void setSixPdBTrd(String sixPdBTrd)
    {
        this.sixPdBTrd = sixPdBTrd;
    }

    public String getSixPdBFoh()
    {
        return sixPdBFoh;
    }

    public void setSixPdBFoh(String sixPdBFoh)
    {
        this.sixPdBFoh = sixPdBFoh;
    }

    public String getSixPdBFih()
    {
        return sixPdBFih;
    }

    public void setSixPdBFih(String sixPdBFih)
    {
        this.sixPdBFih = sixPdBFih;
    }

    public String getSixPdBSix()
    {
        return sixPdBSix;
    }

    public void setSixPdBSix(String sixPdBSix)
    {
        this.sixPdBSix = sixPdBSix;
    }

    public String getSvnPdBFst()
    {
        return svnPdBFst;
    }

    public void setSvnPdBFst(String svnPdBFst)
    {
        this.svnPdBFst = svnPdBFst;
    }

    public String getSvnPdBSnd()
    {
        return svnPdBSnd;
    }

    public void setSvnPdBSnd(String svnPdBSnd)
    {
        this.svnPdBSnd = svnPdBSnd;
    }

    public String getSvnPdBTrd()
    {
        return svnPdBTrd;
    }

    public void setSvnPdBTrd(String svnPdBTrd)
    {
        this.svnPdBTrd = svnPdBTrd;
    }

    public String getSvnPdBFoh()
    {
        return svnPdBFoh;
    }

    public void setSvnPdBFoh(String svnPdBFoh)
    {
        this.svnPdBFoh = svnPdBFoh;
    }

    public String getSvnPdBFih()
    {
        return svnPdBFih;
    }

    public void setSvnPdBFih(String svnPdBFih)
    {
        this.svnPdBFih = svnPdBFih;
    }

    public String getSvnPdBSix()
    {
        return svnPdBSix;
    }

    public void setSvnPdBSix(String svnPdBSix)
    {
        this.svnPdBSix = svnPdBSix;
    }

    public String getEthPdBFst()
    {
        return ethPdBFst;
    }

    public void setEthPdBFst(String ethPdBFst)
    {
        this.ethPdBFst = ethPdBFst;
    }

    public String getEthPdBSnd()
    {
        return ethPdBSnd;
    }

    public void setEthPdBSnd(String ethPdBSnd)
    {
        this.ethPdBSnd = ethPdBSnd;
    }

    public String getEthPdBTrd()
    {
        return ethPdBTrd;
    }

    public void setEthPdBTrd(String ethPdBTrd)
    {
        this.ethPdBTrd = ethPdBTrd;
    }

    public String getEthPdBFoh()
    {
        return ethPdBFoh;
    }

    public void setEthPdBFoh(String ethPdBFoh)
    {
        this.ethPdBFoh = ethPdBFoh;
    }

    public String getEthPdBFih()
    {
        return ethPdBFih;
    }

    public void setEthPdBFih(String ethPdBFih)
    {
        this.ethPdBFih = ethPdBFih;
    }

    public String getEthPdBSix()
    {
        return ethPdBSix;
    }

    public void setEthPdBSix(String ethPdBSix)
    {
        this.ethPdBSix = ethPdBSix;
    }

    public String getFstPdLFst()
    {
        return fstPdLFst;
    }

    public void setFstPdLFst(String fstPdLFst)
    {
        this.fstPdLFst = fstPdLFst;
    }

    public String getFstPdLSnd()
    {
        return fstPdLSnd;
    }

    public void setFstPdLSnd(String fstPdLSnd)
    {
        this.fstPdLSnd = fstPdLSnd;
    }

    public String getFstPdLTrd()
    {
        return fstPdLTrd;
    }

    public void setFstPdLTrd(String fstPdLTrd)
    {
        this.fstPdLTrd = fstPdLTrd;
    }

    public String getFstPdLFoh()
    {
        return fstPdLFoh;
    }

    public void setFstPdLFoh(String fstPdLFoh)
    {
        this.fstPdLFoh = fstPdLFoh;
    }

    public String getFstPdLFih()
    {
        return fstPdLFih;
    }

    public void setFstPdLFih(String fstPdLFih)
    {
        this.fstPdLFih = fstPdLFih;
    }

    public String getFstPdLSix()
    {
        return fstPdLSix;
    }

    public void setFstPdLSix(String fstPdLSix)
    {
        this.fstPdLSix = fstPdLSix;
    }

    public String getSndPdLFst()
    {
        return sndPdLFst;
    }

    public void setSndPdLFst(String sndPdLFst)
    {
        this.sndPdLFst = sndPdLFst;
    }

    public String getSndPdLSnd()
    {
        return sndPdLSnd;
    }

    public void setSndPdLSnd(String sndPdLSnd)
    {
        this.sndPdLSnd = sndPdLSnd;
    }

    public String getSndPdLTrd()
    {
        return sndPdLTrd;
    }

    public void setSndPdLTrd(String sndPdLTrd)
    {
        this.sndPdLTrd = sndPdLTrd;
    }

    public String getSndPdLFoh()
    {
        return sndPdLFoh;
    }

    public void setSndPdLFoh(String sndPdLFoh)
    {
        this.sndPdLFoh = sndPdLFoh;
    }

    public String getSndPdLFih()
    {
        return sndPdLFih;
    }

    public void setSndPdLFih(String sndPdLFih)
    {
        this.sndPdLFih = sndPdLFih;
    }

    public String getSndPdLSix()
    {
        return sndPdLSix;
    }

    public void setSndPdLSix(String sndPdLSix)
    {
        this.sndPdLSix = sndPdLSix;
    }

    public String getTrdPdLFst()
    {
        return trdPdLFst;
    }

    public void setTrdPdLFst(String trdPdLFst)
    {
        this.trdPdLFst = trdPdLFst;
    }

    public String getTrdPdLSnd()
    {
        return trdPdLSnd;
    }

    public void setTrdPdLSnd(String trdPdLSnd)
    {
        this.trdPdLSnd = trdPdLSnd;
    }

    public String getTrdPdLTrd()
    {
        return trdPdLTrd;
    }

    public void setTrdPdLTrd(String trdPdLTrd)
    {
        this.trdPdLTrd = trdPdLTrd;
    }

    public String getTrdPdLFoh()
    {
        return trdPdLFoh;
    }

    public void setTrdPdLFoh(String trdPdLFoh)
    {
        this.trdPdLFoh = trdPdLFoh;
    }

    public String getTrdPdLFih()
    {
        return trdPdLFih;
    }

    public void setTrdPdLFih(String trdPdLFih)
    {
        this.trdPdLFih = trdPdLFih;
    }

    public String getTrdPdLSix()
    {
        return trdPdLSix;
    }

    public void setTrdPdLSix(String trdPdLSix)
    {
        this.trdPdLSix = trdPdLSix;
    }

    public String getFohPdLFst()
    {
        return fohPdLFst;
    }

    public void setFohPdLFst(String fohPdLFst)
    {
        this.fohPdLFst = fohPdLFst;
    }

    public String getFohPdLSnd()
    {
        return fohPdLSnd;
    }

    public void setFohPdLSnd(String fohPdLSnd)
    {
        this.fohPdLSnd = fohPdLSnd;
    }

    public String getFohPdLTrd()
    {
        return fohPdLTrd;
    }

    public void setFohPdLTrd(String fohPdLTrd)
    {
        this.fohPdLTrd = fohPdLTrd;
    }

    public String getFohPdLFoh()
    {
        return fohPdLFoh;
    }

    public void setFohPdLFoh(String fohPdLFoh)
    {
        this.fohPdLFoh = fohPdLFoh;
    }

    public String getFohPdLFih()
    {
        return fohPdLFih;
    }

    public void setFohPdLFih(String fohPdLFih)
    {
        this.fohPdLFih = fohPdLFih;
    }

    public String getFohPdLSix()
    {
        return fohPdLSix;
    }

    public void setFohPdLSix(String fohPdLSix)
    {
        this.fohPdLSix = fohPdLSix;
    }

    public String getFihPdLFst()
    {
        return fihPdLFst;
    }

    public void setFihPdLFst(String fihPdLFst)
    {
        this.fihPdLFst = fihPdLFst;
    }

    public String getFihPdLSnd()
    {
        return fihPdLSnd;
    }

    public void setFihPdLSnd(String fihPdLSnd)
    {
        this.fihPdLSnd = fihPdLSnd;
    }

    public String getFihPdLTrd()
    {
        return fihPdLTrd;
    }

    public void setFihPdLTrd(String fihPdLTrd)
    {
        this.fihPdLTrd = fihPdLTrd;
    }

    public String getFihPdLFoh()
    {
        return fihPdLFoh;
    }

    public void setFihPdLFoh(String fihPdLFoh)
    {
        this.fihPdLFoh = fihPdLFoh;
    }

    public String getFihPdLFih()
    {
        return fihPdLFih;
    }

    public void setFihPdLFih(String fihPdLFih)
    {
        this.fihPdLFih = fihPdLFih;
    }

    public String getFihPdLSix()
    {
        return fihPdLSix;
    }

    public void setFihPdLSix(String fihPdLSix)
    {
        this.fihPdLSix = fihPdLSix;
    }

    public String getSixPdLFst()
    {
        return sixPdLFst;
    }

    public void setSixPdLFst(String sixPdLFst)
    {
        this.sixPdLFst = sixPdLFst;
    }

    public String getSixPdLSnd()
    {
        return sixPdLSnd;
    }

    public void setSixPdLSnd(String sixPdLSnd)
    {
        this.sixPdLSnd = sixPdLSnd;
    }

    public String getSixPdLTrd()
    {
        return sixPdLTrd;
    }

    public void setSixPdLTrd(String sixPdLTrd)
    {
        this.sixPdLTrd = sixPdLTrd;
    }

    public String getSixPdLFoh()
    {
        return sixPdLFoh;
    }

    public void setSixPdLFoh(String sixPdLFoh)
    {
        this.sixPdLFoh = sixPdLFoh;
    }

    public String getSixPdLFih()
    {
        return sixPdLFih;
    }

    public void setSixPdLFih(String sixPdLFih)
    {
        this.sixPdLFih = sixPdLFih;
    }

    public String getSixPdLSix()
    {
        return sixPdLSix;
    }

    public void setSixPdLSix(String sixPdLSix)
    {
        this.sixPdLSix = sixPdLSix;
    }

    public String getSvnPdLFst()
    {
        return svnPdLFst;
    }

    public void setSvnPdLFst(String svnPdLFst)
    {
        this.svnPdLFst = svnPdLFst;
    }

    public String getSvnPdLSnd()
    {
        return svnPdLSnd;
    }

    public void setSvnPdLSnd(String svnPdLSnd)
    {
        this.svnPdLSnd = svnPdLSnd;
    }

    public String getSvnPdLTrd()
    {
        return svnPdLTrd;
    }

    public void setSvnPdLTrd(String svnPdLTrd)
    {
        this.svnPdLTrd = svnPdLTrd;
    }

    public String getSvnPdLFoh()
    {
        return svnPdLFoh;
    }

    public void setSvnPdLFoh(String svnPdLFoh)
    {
        this.svnPdLFoh = svnPdLFoh;
    }

    public String getSvnPdLFih()
    {
        return svnPdLFih;
    }

    public void setSvnPdLFih(String svnPdLFih)
    {
        this.svnPdLFih = svnPdLFih;
    }

    public String getSvnPdLSix()
    {
        return svnPdLSix;
    }

    public void setSvnPdLSix(String svnPdLSix)
    {
        this.svnPdLSix = svnPdLSix;
    }

    public String getEthPdLFst()
    {
        return ethPdLFst;
    }

    public void setEthPdLFst(String ethPdLFst)
    {
        this.ethPdLFst = ethPdLFst;
    }

    public String getEthPdLSnd()
    {
        return ethPdLSnd;
    }

    public void setEthPdLSnd(String ethPdLSnd)
    {
        this.ethPdLSnd = ethPdLSnd;
    }

    public String getEthPdLTrd()
    {
        return ethPdLTrd;
    }

    public void setEthPdLTrd(String ethPdLTrd)
    {
        this.ethPdLTrd = ethPdLTrd;
    }

    public String getEthPdLFoh()
    {
        return ethPdLFoh;
    }

    public void setEthPdLFoh(String ethPdLFoh)
    {
        this.ethPdLFoh = ethPdLFoh;
    }

    public String getEthPdLFih()
    {
        return ethPdLFih;
    }

    public void setEthPdLFih(String ethPdLFih)
    {
        this.ethPdLFih = ethPdLFih;
    }

    public String getEthPdLSix()
    {
        return ethPdLSix;
    }

    public void setEthPdLSix(String ethPdLSix)
    {
        this.ethPdLSix = ethPdLSix;
    }*/

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }

    public String getSortNo()
    {
        return sortNo;
    }

    public void setSortNo(String sortNo)
    {
        this.sortNo = sortNo;
    }

    public String getSpellNo()
    {
        return spellNo;
    }

    public void setSpellNo(String spellNo)
    {
        this.spellNo = spellNo;
    }

    public String getWubiNo()
    {
        return wubiNo;
    }

    public void setWubiNo(String wubiNo)
    {
        this.wubiNo = wubiNo;
    }

    public BigInteger getUpdCnt()
    {
        return updCnt;
    }

    public void setUpdCnt(BigInteger updCnt)
    {
        this.updCnt = updCnt;
    }

    public Timestamp getCrtTime()
    {
        return crtTime;
    }

    public void setCrtTime(Timestamp crtTime)
    {
        this.crtTime = crtTime;
    }

    public String getCrtUserId()
    {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId)
    {
        this.crtUserId = crtUserId;
    }

    public String getCrtDeptCd()
    {
        return crtDeptCd;
    }

    public void setCrtDeptCd(String crtDeptCd)
    {
        this.crtDeptCd = crtDeptCd;
    }

    public Timestamp getLastUpdTime()
    {
        return lastUpdTime;
    }

    public void setLastUpdTime(Timestamp lastUpdTime)
    {
        this.lastUpdTime = lastUpdTime;
    }

    public String getLastUpdDeptCd()
    {
        return lastUpdDeptCd;
    }

    public void setLastUpdDeptCd(String lastUpdDeptCd)
    {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    public String getLastUpdUserId()
    {
        return lastUpdUserId;
    }

    public void setLastUpdUserId(String lastUpdUserId)
    {
        this.lastUpdUserId = lastUpdUserId;
    }

    public Short getDelF()
    {
        return delF;
    }

    public void setDelF(Short delF)
    {
        this.delF = delF;
    }

    public String getValueStr()
    {
        return valueStr;
    }

    public void setValueStr(String valueStr)
    {
        this.valueStr = valueStr;
    }

    public String getColDisabled()
    {
        return colDisabled;
    }

    public void setColDisabled(String colDisabled)
    {
        this.colDisabled = colDisabled;
    }
}
