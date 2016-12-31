Ext.define('iih.po.com.block.KnowledgeData', {
    extend : 'Ext.view.View',

    requires: [],

    alias:'widget.knowledgedata',

    tpl: [
        '<tpl for=".">',
        '<div class="knowledgedata">',
        '<table width="100%">',
        '<tr><td style="padding-left: 0"><textarea name="knowledgeArea" rows="5" cols="25">{fragmentTplContent}</textarea></td>',
        '</tr>',
        '</table>',
        '</div>',
        '</tpl>'
    ],
    
    itemSelector: 'div.knowledgedata'
})