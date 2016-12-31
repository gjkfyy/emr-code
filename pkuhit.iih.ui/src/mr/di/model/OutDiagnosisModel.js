Ext.define('iih.mr.di.model.OutDiagnosisModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'diSn',     type: 'string'},//诊断序号
        {name: 'diCd',     type: 'string'},//诊断编码
        {name: 'diNm', type: 'string'},//诊断名称
 		{name:'lvl',type:'int'},//层级
 		{name:'suspected',type:'bool'}, //疑似标志
 		{name:'tochek',type:'bool'}, //待查标志
 		{name:'addDescr',type:'string'} ,//补充说明
 		{name:'icdCd',type:'string'},//ICD编码
 		{name:'diEmpCd',type:'string'},//诊断医师编码
 		{name:'diEmpNm',type:'string'},//诊断医师
 		{name:'diTime',type:'long',defaultValue:new Date().getTime()},//诊断时间
 		{name:'stopUseF',type:'int',defaultValue:0},//确认结果
 		{name:'updCount',type:'int',defaultValue:0},
 		{name:'setOwnerTypeCd',type:'string',defaultValue:''},
 		{name:'setOwnerCd',type:'string',defaultValue:''},
 		{name:'mainF',type:'int',defaultValue:0}
 		        
    ]
//     validations: [                 
//          {type: 'length',   name: 'addDescr', min: 5},               
//     ]
   /* proxy:{
        type: 'memory',
        id: 'DiagnosisEntry-List'
    }*/ 
});