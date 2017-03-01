Ext.define('iih.sy.patient.block.WrTemplateListBlock',{
    extend : 'Xap.ej.block.Block',

    requires: [
        'Xap.ej.element.grid.Grid',  
        'Xap.ej.element.grid.column.ActionColumn'
    ],

    alias:'widget.wrTemplateListBlock',

    //layout: 'fit',

    items: [{
        title: '病历模板一览',
        
        //maxHeight: 800,
        
        xtype: 'xapgrid',

        CM_JR_Record: [
           {header: '模板id',dataIndex: 'code',hidden:true},
           {header: '文件主键',dataIndex: 'filePk',hidden:true},
           {header: '医疗记录类型编码',dataIndex: 'mrTypeCode',hidden:true},
//           {header: '模板标准编码',dataIndex: 'mrTplKc',hidden:true},
           {header: '医疗记录类型名称',dataIndex: 'mrTypeName',hidden:true},
           {header: '病历模板名称',dataIndex: 'name',field: 'textfield',type: 'string',flex:1},
           {header: '适用病种',dataIndex: 'diNames',field: 'textfield',type: 'string',width:150},
           {header: '所属',dataIndex: 'ownerName',field: 'textfield',type: 'string',width:150},
           {header: '审签级别编码',dataIndex: 'signLevelCode',hidden:true},
           {header: '审签级别',dataIndex: 'signLevelName',field: 'textfield',type: 'string',width: 150}
        ],
        autoScroll:true,
        height:250/*,
    	gridData:{
			'results':[
				{'mrTplVerKc': '001', "mrTypeCd":"MRM003.01",'mrTplKc':"001" ,'mrTypeNm':"其他病历类型",'mrTplNm':"XXXXX1",'mrTplDiNm':"xx1xxx",'ownerCd':"个人",'signLvlCd':"1"},
				{'mrTplVerKc': '002', "mrTypeCd":"MRM003.12",'mrTplKc':"002" ,'mrTypeNm':"上级医师查房记录",'mrTplNm':"XXXXX2",'mrTplDiNm':"x2xxxx",'ownerCd':"科室",'signLvlCd':"1"},
				{'mrTplVerKc': '003', "mrTypeCd":"MRM003.11",'mrTplKc':"003" ,'mrTypeNm':"手术记录",'mrTplNm':"XXXXX3",'mrTplDiNm':"xxx3xx",'ownerCd':"全院",'signLvlCd':"1"},
				{'mrTplVerKc': '004', "mrTypeCd":"MRM003.10",'mrTplKc':"004" ,'mrTypeNm':"会诊记录",'mrTplNm':"XXXXX4",'mrTplDiNm':"xxx4xx",'ownerCd':"科室",'signLvlCd':"1"},
				{'mrTplVerKc': '005', "mrTypeCd":"MRM003.02",'mrTplKc':"005" ,'mrTypeNm':"其他病历类型",'mrTplNm':"XXXXX5",'mrTplDiNm':"xx5xxx",'ownerCd':"科室",'signLvlCd':"1"},
				{'mrTplVerKc': '006', "mrTypeCd":"MRM003.03",'mrTplKc':"006" ,'mrTypeNm':"其他病历类型",'mrTplNm':"XXXXX6",'mrTplDiNm':"xxx6xx",'ownerCd':"个人",'signLvlCd':"1"}
			]
        }*/
    }],

    setData: function(data) {
        var grid = this.down('xapgrid');
        if(grid){
        	grid.setData(data);
        }
    }
})