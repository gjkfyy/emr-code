Ext.define('iih.po.inp.block.InpPatientData', {
    extend : 'Ext.view.View',

    requires: [],

    alias:'widget.inppatientdata',

    tpl: [
        '<tpl for=".">',
        '<div class="patientview">',
        '<table width="100%">',
        '<tr><td rowspan="2" style="padding-left: 0"><img src="css/images/man_48_1.png"/></td>',
            '<td class="thumb" colspan="3">',
            '{currentBedCode}' + '床',
        '</td></tr>',
        '<tr><td class="thumb patientNm">{patientName}</td><td class="thumb sexCd">{sexName}</td>',
        '<td class="thumb patientAge">',
            '{age}'+'岁',
        '</td></tr>',
        '</table>',
        '</div>',
        '</tpl>'
    ],
    
    itemSelector: 'div.patientview'
})