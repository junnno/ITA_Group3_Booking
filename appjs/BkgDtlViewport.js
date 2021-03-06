/*
 * File: app/view/BkgDtlViewport.js
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

Ext.define('Booking.view.BkgDtlViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.bkgdtlviewport',

    requires: [
        'Booking.view.BkgDtlViewportViewModel',
        'Booking.view.MainController',
        'Ext.Img',
        'Ext.button.Button',
        'Ext.form.FieldSet',
        'Ext.form.field.ComboBox',
        'Ext.form.RadioGroup',
        'Ext.form.field.Radio',
        'Ext.toolbar.Toolbar',
        'Ext.grid.Panel',
        'Ext.grid.column.Number'
    ],

    controller: 'bkgdtlviewport',
    viewModel: {
        type: 'bkgdtlviewport'
    },
    flex: 1,
    height: 250,
    id: 'BkgDtlViewportId',
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
            flex: 1,
            id: 'createBookingContainerId',
            layout: 'fit',
            items: [
                {
                    xtype: 'panel',
                    flex: 1,
                    id: 'createBookingId',
                    scrollable: true,
                    bodyPadding: 10,
                    title: 'Booking Details',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'button',
                            id: 'logOut1',
                            scale: 'medium',
                            text: 'LogOut'
                        },
                        {
                            xtype: 'container',
                            id: 'bookingDetailContainerId',
                            layout: {
                                type: 'vbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'fieldset',
                                    flex: 1,
                                    layout: 'fit',
                                    title: 'Booking Info',
                                    items: [
                                        {
                                            xtype: 'container',
                                            layout: 'hbox',
                                            items: [
                                                {
                                                    xtype: 'container',
                                                    flex: 1,
                                                    items: [
                                                        {
                                                            xtype: 'textfield',
                                                            disabled: true,
                                                            id: 'BkgNumId',
                                                            fieldLabel: 'Booking #'
                                                        },
                                                        {
                                                            xtype: 'textfield',
                                                            id: 'BkgConId',
                                                            fieldLabel: 'Consignee',
                                                            allowBlank: false,
                                                            emptyText: 'Input a Consignee',
                                                            enforceMaxLength: true,
                                                            maxLength: 40
                                                        },
                                                        {
                                                            xtype: 'textfield',
                                                            id: 'BkgShpId',
                                                            fieldLabel: 'Shipper',
                                                            allowBlank: false,
                                                            emptyText: 'Input a Shipper',
                                                            enforceMaxLength: true,
                                                            maxLength: 40
                                                        }
                                                    ]
                                                },
                                                {
                                                    xtype: 'container',
                                                    flex: 1,
                                                    margin: '0 0 0 10',
                                                    items: [
                                                        {
                                                            xtype: 'combobox',
                                                            id: 'BkgFrmCityid',
                                                            fieldLabel: 'From City',
                                                            displayField: 'code',
                                                            enableRegEx: false,
                                                            forceSelection: true,
                                                            queryMode: 'local',
                                                            store: 'CityStore',
                                                            valueField: 'code'
                                                        },
                                                        {
                                                            xtype: 'combobox',
                                                            id: 'BkgToCityId',
                                                            fieldLabel: 'To City',
                                                            displayField: 'name',
                                                            forceSelection: true,
                                                            queryMode: 'local',
                                                            store: 'CityStore',
                                                            valueField: 'code'
                                                        }
                                                    ]
                                                }
                                            ]
                                        }
                                    ]
                                },
                                {
                                    xtype: 'fieldset',
                                    flex: 1,
                                    layout: 'auto',
                                    title: 'Container Details',
                                    items: [
                                        {
                                            xtype: 'radiogroup',
                                            id: 'CgoNatId',
                                            width: 400,
                                            fieldLabel: 'Cargo Nature',
                                            items: [
                                                {
                                                    xtype: 'radiofield',
                                                    id: 'gcCgoNatId',
                                                    boxLabel: 'GC',
                                                    inputValue: 'GC'
                                                },
                                                {
                                                    xtype: 'radiofield',
                                                    id: 'dgCgoNatId',
                                                    boxLabel: 'DG',
                                                    inputValue: 'DG'
                                                },
                                                {
                                                    xtype: 'radiofield',
                                                    id: 'rfCgoNatId',
                                                    boxLabel: 'RF',
                                                    inputValue: 'RF'
                                                },
                                                {
                                                    xtype: 'radiofield',
                                                    id: 'awCgoNatId',
                                                    boxLabel: 'AW',
                                                    inputValue: 'AW'
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'textfield',
                                            flex: 1,
                                            id: 'CgoDescId',
                                            width: 500,
                                            fieldLabel: 'Cargo Description',
                                            enforceMaxLength: true,
                                            maxLength: 100
                                        },
                                        {
                                            xtype: 'container',
                                            frame: false,
                                            layout: {
                                                type: 'vbox',
                                                align: 'stretch'
                                            },
                                            items: [
                                                {
                                                    xtype: 'toolbar',
                                                    border: 1,
                                                    items: [
                                                        {
                                                            xtype: 'button',
                                                            text: 'Add',
                                                            listeners: {
                                                                click: 'onCntrInfoAdd'
                                                            }
                                                        },
                                                        {
                                                            xtype: 'button',
                                                            text: 'Remove',
                                                            listeners: {
                                                                click: 'onCntrInfoDel'
                                                            }
                                                        }
                                                    ]
                                                },
                                                {
                                                    xtype: 'gridpanel',
                                                    flex: 1,
                                                    border: true,
                                                    frame: true,
                                                    height: 180,
                                                    id: 'CntrInfoGridId',
                                                    margin: '0 0 10 0',
                                                    maxHeight: 240,
                                                    padding: '',
                                                    scrollable: true,
                                                    bodyBorder: true,
                                                    columnLines: true,
                                                    store: 'CntrStore',
                                                    columns: [
                                                        {
                                                            xtype: 'gridcolumn',
                                                            flex: 1,
                                                            dataIndex: 'CntrType',
                                                            text: 'Container Type'
                                                        },
                                                        {
                                                            xtype: 'numbercolumn',
                                                            flex: 1,
                                                            dataIndex: 'CntrNet',
                                                            text: 'Net Weight',
                                                            format: '000,000.00'
                                                        },
                                                        {
                                                            xtype: 'numbercolumn',
                                                            flex: 1,
                                                            dataIndex: 'CntrGross',
                                                            text: 'Gross Weight',
                                                            format: '000,000.00'
                                                        },
                                                        {
                                                            xtype: 'gridcolumn',
                                                            flex: 1,
                                                            dataIndex: 'CntrUnit',
                                                            text: 'Weight Unit'
                                                        }
                                                    ]
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            id: 'bookingValidationContainerId',
                            padding: 5,
                            items: [
                                {
                                    xtype: 'checkboxgroup',
                                    margin: '0 10 0 0',
                                    fieldLabel: 'Validation',
                                    items: [
                                        {
                                            xtype: 'checkboxfield',
                                            id: 'validWgtId',
                                            boxLabel: 'Valid Weight'
                                        },
                                        {
                                            xtype: 'checkboxfield',
                                            id: 'ApproveDocId',
                                            boxLabel: 'Approved Documents'
                                        },
                                        {
                                            xtype: 'checkboxfield',
                                            id: 'GoodCusId',
                                            boxLabel: 'Good Customer'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'button',
                                    text: 'Save',
                                    listeners: {
                                        click: 'onBkgSave'
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]

});