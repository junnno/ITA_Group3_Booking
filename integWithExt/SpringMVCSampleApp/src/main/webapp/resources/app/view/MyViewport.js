/*
 * File: app/view/MyViewport.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('MyApp.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.View',
        'Ext.button.Button'
    ],

    itemId: 'myviewport',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    itemId: 'mygridpanel',
                    title: 'My Grid Panel',
                    columns: [
                        {
                            xtype: 'numbercolumn',
                            text: 'Id'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'string',
                            text: 'Name'
                        },
                        {
                            xtype: 'datecolumn',
                            dataIndex: 'date',
                            text: 'Joining Date'
                        },
                        {
                            xtype: 'numbercolumn',
                            dataIndex: 'number',
                            text: 'salary'
                        },
                        {
                            xtype: 'numbercolumn',
                            text: 'ssn'
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'loadButton',
                            onLoadClick: function() {
                                var store = Ext.getStore('EmployeeStore');



                                Ext.Ajax.request({

                                    url : '/getSencha',

                                    params : {
                                    },

                                    scope : this,

                                    success : function(response) {

                                        var data = Ext.decode(response.responseText);

                                        Ext.each(data, function(record){

                                            var employee = {

                                                Id:record.id,

                                                Name:record.name,

                                                JoiningDate:record.joiningDate,

                                                Salary:record.salary,

                                                Ssn:record.ssn

                                            };

                                            store.add(employee);

                                        });

                                    }

                                });
                            },
                            dock: 'left',
                            itemId: 'loadButton',
                            width: 100,
                            text: 'load'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});