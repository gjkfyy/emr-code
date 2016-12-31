package pkuhit.iih.qa.qacustom.stat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.dao.qacustom.CusQaStatisticsDao;
import pkuhit.iih.qa.qacustom.QaStatisticsService;
import pkuhit.xap.stat.Column;
import pkuhit.xap.stat.DataModule;
import pkuhit.xap.stat.Row;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

public class QaStatisticsServiceImpl implements QaStatisticsService{

	@Autowired
	CusQaStatisticsDao cusQaStatisticsDao;
	
	@Override
	public SingleResult<DataModule> amrLevelRateStat(Map param) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> datas = cusQaStatisticsDao.selectAmrLevelRate();
		DataModule dataModule = new DataModule();
		
		Column deptNmColumn = new Column();
		deptNmColumn.setName("科室");
		deptNmColumn.setCode("deptNm");
		Column amrCountsColumn = new Column();
		amrCountsColumn.setName("病例数");
		amrCountsColumn.setCode("amrCounts");
		Column firstLevelColumn = new Column();
		firstLevelColumn.setName("甲级");
		firstLevelColumn.setCode("firstLevel");
		Column firstLevelRateColumn = new Column();
		firstLevelRateColumn.setName("甲级百分率");
		firstLevelRateColumn.setCode("firstLevelRate");
		Column secondLevelColumn = new Column();
		secondLevelColumn.setName("乙级");
		secondLevelColumn.setCode("secondLevel");
		Column secondLevelRateColumn = new Column();
		secondLevelRateColumn.setName("乙级百分率");
		secondLevelRateColumn.setCode("secondLevelRate");
		Column thirdLevelColumn = new Column();
		thirdLevelColumn.setName("丙级");
		thirdLevelColumn.setCode("thirdLevel");
		dataModule.getColumnList().add(deptNmColumn);
		dataModule.getColumnList().add(amrCountsColumn);
		dataModule.getColumnList().add(firstLevelColumn);
		dataModule.getColumnList().add(firstLevelRateColumn);
		dataModule.getColumnList().add(secondLevelColumn);
		dataModule.getColumnList().add(secondLevelRateColumn);
		dataModule.getColumnList().add(thirdLevelColumn);
		
		if (datas != null) {
			for (Map<String, Object> map : datas) {
				Row row = new Row();
				row.setName((String) map.get("NM"));
				row.setCode((String)map.get("DEPTCD"));
				BigDecimal firstLevel = (BigDecimal) (map.get("FIRSTLEVEL")==null?0:map.get("FIRSTLEVEL"));
				BigDecimal secondLevel = (BigDecimal) (map.get("SECONDLEVEL")==null?0:map.get("SECONDLEVEL"));
				BigDecimal thirdLevel = (BigDecimal) (map.get("THIRDLEVEL")==null?0:map.get("THIRDLEVEL"));
				int total = firstLevel.intValue()+secondLevel.intValue()+thirdLevel.intValue();
				float firstLevelRate = (total == 0?0:firstLevel.floatValue()/total)*100;
				float secondLevelRate = (total == 0?0:secondLevel.floatValue()/total)*100;
				dataModule.getRowList().add(row);
				dataModule.setDataRC(row.getCode(),deptNmColumn.getCode() , row.getName());
				dataModule.setDataRC(row.getCode(),amrCountsColumn.getCode() ,total);
				dataModule.setDataRC(row.getCode(), firstLevelColumn.getCode(), firstLevel);
				dataModule.setDataRC(row.getCode(), firstLevelRateColumn.getCode(), firstLevelRate==0?0:(new DecimalFormat("#.#")).format(firstLevelRate)+"%");
				dataModule.setDataRC(row.getCode(), secondLevelColumn.getCode(), secondLevel);
				dataModule.setDataRC(row.getCode(), secondLevelRateColumn.getCode(), secondLevelRate==0?0:(new DecimalFormat("#.#")).format(secondLevelRate)+"%");
				dataModule.setDataRC(row.getCode(), thirdLevelColumn.getCode(),thirdLevel);
			}
		}
		SingleResultBuilder<DataModule> builder = SingleResultBuilder.newSingleResult(DataModule.class);
		builder.withData(dataModule);
		return builder.build();
	}

}
