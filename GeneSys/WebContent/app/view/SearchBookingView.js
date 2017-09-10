/*
 * File: app/view/SearchBookingView.js
 *
 * This file was generated by Sencha Architect version 4.2.2.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 6.5.x Classic library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 6.5.x Classic. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Booking.view.SearchBookingView', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.searchbookingview',
    id:'SearchBookingView',
    rowSelection: "yow",
    requires: [
        'Booking.view.SearchBookingViewViewModel',
        'Ext.Img',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Fill',
        'Ext.form.field.ComboBox',
        'Ext.tab.Panel',
        'Ext.tab.Tab',
        'Ext.grid.Panel',
        'Ext.grid.column.Column',
        'Ext.view.Table'
    ],

    viewModel: {
        type: 'searchbookingview'
    },
    height: 250,
    scrollable: 'vertical',
    width: 400,
    layout: 'fit',

    items: [
        {
            xtype: 'image',
            dock: 'top',
            height: '',
            maxHeight: 45,
            maxWidth: 100,
            src: 'brand.png'
        },
        {
            xtype: 'container',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [
                {
                    xtype: 'panel',
                    bodyPadding: 35,
                    title: 'Search Booking',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            width: 848,
                            items: [
                                {
                                    xtype: 'tbfill',
                                    dock: 'right'
                                },
                                {
                                    xtype: 'button',
                                    id: 'createButton',
                                    itemId: 'createButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Create'
                                },
                                {
                                    xtype: 'button',
                                    id: 'updateButton',
                                    itemId: 'updateButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Update',
                                    disabled: true
                                },
                                {
                                    xtype: 'button',
                                    id: 'userButton',
                                    itemId: 'userButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'User'
                                },
                                {
                                    xtype: 'button',
                                    id: 'searchButton1',
                                    itemId: 'searchButton1',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Search'
                                },
                                {
                                    xtype: 'button',
                                    id: 'logOut',
                                    scale: 'medium',
                                    text: 'Logout'
                                }
                            ]
                        }
                    ],
                    items: [
                        {
                            xtype: 'container',
                            flex: 1,
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Booking'
                                },
                                {
                                    xtype: 'textfield',
                                    maxWidth: 60,
                                    fieldLabel: 'Container'
                                },
                                {
                                    xtype: 'combobox',
                                    maxWidth: 60,
                                    modelValidation: true,
                                    fieldLabel: 'Status',
                                    displayField: 'Key',
                                    forceSelection: true,
                                    queryMode: 'local',
                                    valueField: 'Value'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 1,
                            margin: '',
                            items: [
                                {
                                    xtype: 'combobox',
                                    maxWidth: 60,
                                    fieldLabel: 'From',
                                    displayField: 'name',
                                    forceSelection: true,
                                    queryMode: 'local',
                                    store: 'CityStore',
                                    valueField: 'code'
                                },
                                {
                                    xtype: 'combobox',
                                    maxWidth: 60,
                                    fieldLabel: 'To',
                                    displayField: 'name',
                                    forceSelection: true,
                                    queryMode: 'local',
                                    store: 'CityStore',
                                    valueField: 'code'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'tabpanel',
                    flex: 1,
                    bodyPadding: 5,
                    activeTab: 0,
                    items: [
                        {
                            xtype: 'panel',
                            flex: 1,
                            bodyBorder: false,
                            bodyPadding: 20,
                            title: 'Booking Details',
                            tabConfig: {
                                xtype: 'tab',
                                padding: 5
                            },
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    id : 'bookingGridId',
                                    titleCollapse: false,
                                    forceFit: true,
                                    store: 'BkgStore',
                                    listeners : {
                                    	rowclick: function(searchgrid, rowIndex, e) {
//                                    		var a = Ext.getStore('BkgStore');
//                                            var record = a.getAt(rowIndex);
//                                            alert(record.data.id);
                                    		var cmp = Ext.getCmp('bookingGridId');
                                            this.rowSelection = cmp.getSelection();
                                            var store = Ext.getStore('BkgStore');
                                            console.log(this.rowSelection);
                                            Ext.getCmp('updateButton').setDisabled(false);
                                            
                                        }
                                     }, 
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'BkgNum',
                                            text: 'Booking Number'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'Shipper',
                                            text: 'Shipper'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'Consignee',
                                            text: 'Consignee'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex:'From',
                                            text: 'From'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'To',
                                            text: 'To'
                                        }
                                    ],
                                    viewConfig: {
                                        height: 100
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            border: false,
                            bodyPadding: 20,
                            title: 'Container Details',
                            tabConfig: {
                                xtype: 'tab',
                                padding: 5
                            },
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    forceFit: true,
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'CntrNumber',
                                            text: 'Container Number'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'CntrTypes',
                                            text: 'Container Type'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'GrossWeight',
                                            text: 'Gross Weight'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'NetWeight',
                                            text: 'Net Weight'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'CargoNature',
                                            text: 'Cargo Nature'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'CargoDescription',
                                            text: 'Cargo Description'
                                        }
                                    ],
                                    viewConfig: {
                                        height: 105
                                    }
                                }
                            ]
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            ui: 'footer',
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'tbfill'
                                },
                                {
                                    xtype: 'button',
                                    id: 'updateBtn',
                                    itemId: 'updateBtn',
                                    scale: 'medium',
                                    text: 'Update'
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]

});