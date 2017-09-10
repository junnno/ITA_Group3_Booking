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
                                    titleCollapse: false,
                                    forceFit: true,
                                    store: 'BkgStore',
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
                                            dataIndex: 'string',
                                            text: 'Consignee'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            text: 'From'
                                        },
                                        {
                                            xtype: 'gridcolumn',
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
                                            dataIndex: 'string',
                                            text: 'Container Number'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            text: 'Container Type'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            text: 'Gross Weight'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            text: 'Net Weight'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            text: 'Cargo Nature'
                                        },
                                        {
                                            xtype: 'gridcolumn',
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
                                    itemId: 'mybutton2',
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