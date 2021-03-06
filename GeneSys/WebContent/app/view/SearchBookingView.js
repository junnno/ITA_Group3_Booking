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
            xtype: 'container',
            items: [
                {
                    xtype: 'container',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [
                    	{
                            xtype: 'image',
                            flex: 1,
                            dock: 'top',
                            height: '',
                            maxHeight: 80,
                            maxWidth: 200,
                            padding: 10,
                            src: 'brand2.png'
                        },
                        {
                            xtype: 'toolbar',
                            flex: 1,
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                            	 {
                                     xtype: 'button',
                                     id: 'userButton',
                                     itemId: 'userButton',
                                     allowDepress: false,
                                     scale: 'medium',
                                     text: 'Users',
                                     listeners: {
                                         'beforerender' : function() {
                                         	 Ext.Ajax.request({
                                   				url : 'user/getAuth',
                                   				method : 'POST',
                                   				scope : this,
                                   				success : function(response) {
                                   					if(response.responseText == "3" || response.responseText == "2") Ext.getCmp('userButton').hide();
                                   				}
                                   			});	
                                         }
                                     }
                                 },
                            	 {
                                     xtype: 'button',
                                     id: 'searchButton',
                                     itemId: 'searchButton',
                                     allowDepress: false,
                                     scale: 'medium',
                                     text: 'Booking'
                                 },
                                 {
                                     xtype: 'button',
                                     id: 'logOut',
                                     scale: 'medium',
                                     text: 'Logout'
                                 }
                            ]
                        }
                    ]
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
                                    id: 'searchButton1',
                                    itemId: 'searchButton1',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Search'
                                },
                                /*{
                                    xtype: 'button',
                                    id: 'updateButton',
                                    itemId: 'updateButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Update',
                                    disabled: true,
                                    listeners: {
                                        'beforerender' : function() {
                                        	 Ext.Ajax.request({
                                  				url : 'user/getAuth',
                                  				method : 'POST',
                                  				scope : this,
                                  				success : function(response) {
                                  					if(response.responseText == "3") Ext.getCmp('updateButton').hide();
                                  				}
                                  			});	
                                        }
                                    }
                                },*/
                                {
                                    xtype: 'button',
                                    id: 'createButton',
                                    itemId: 'createButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Create',
                                    listeners: {
                                        'beforerender' : function() {
                                        	 Ext.Ajax.request({
                                  				url : 'user/getAuth',
                                  				method : 'POST',
                                  				scope : this,
                                  				success : function(response) {
                                  					if(response.responseText == "3") Ext.getCmp('createButton').hide();
                                  				}
                                  			});	
                                        }
                                    }
                                    
                                },
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
                                    id:'bkgNum',
                                    fieldLabel: 'Booking'
                                },
                                {
                                    xtype: 'textfield',
                                    id:'cntrNum',
                                    maxWidth: 60,
                                    fieldLabel: 'Container'
                                },
                                {
                                    xtype: 'combobox',
                                    id:'status',
                                    maxWidth: 60,
                                    modelValidation: true,
                                    fieldLabel: 'Status',
                                    displayField: 'Key',
                                    forceSelection: true,
                                    queryMode: 'local',
                                    store: 'StatusStore',
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
                                    id:'fromCity',
                                    fieldLabel: 'From',
                                    displayField: 'code',
                                    forceSelection: true,
                                    queryMode: 'local',
                                    store: 'CityStore',
                                    valueField: 'code'
                                },
                                {
                                    xtype: 'combobox',
                                    maxWidth: 60,
                                    id:'toCity',
                                    fieldLabel: 'To',
                                    displayField: 'code',
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
                            layout: 'auto',
                            bodyBorder: true,
                            frame: true,
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
                                    border: true,
                                    frame: true,
                                    columnLines: true,
                                    titleCollapse: false,
                                    forceFit: true,
                                    store: 'BkgStore',
                                    listeners : {
                                    	rowclick: function(searchgrid, rowIndex, e) {
                                    		var cmp = Ext.getCmp('bookingGridId');
                                    		var containerStore = Ext.getStore('CntrDetailsStore');
                                    		containerStore.removeAll();
                                            var selected = cmp.getSelection();
                                            var store = Ext.getStore('BkgStore');
                                            Ext.each(selected, function(record) {
                                            	var records = record.data.ContainerDetails;
                                            	Ext.each(records, function(recorded) {
                                            		var unit;
                                                	if(recorded.unit == 1) {
                                                		unit = "kg"
                                                	} else {
                                                		unit = "lbs";
                                                	}
                                            		var grossWeight = recorded.grossWeight + unit;
                                                	var netWeight = recorded.netWeight + unit;
                                					var ctrs = {
                                				            CntrNumber : recorded.containerNum,
                                				            CntrTypes : recorded.containerType,
                                				            GrossWeight : grossWeight,
                                				            NetWeight : netWeight,
                                				            CargoNature : recorded.cargoNature,
                                				            CargoDescription : recorded.cargoDesc
                                					};
                                					containerStore.add(ctrs);
                                            	});
                            				});
                                        },
                                        selectionChange: function( searchgrid, selected, eOpts ){
                                        	var selected = Ext.getCmp('bookingGridId').getSelection().length;
                                        	
                                        	if(selected!=1){
                                            	Ext.getCmp('updateButton').setDisabled(true);
                                        	}
                                        	else{
                                            	Ext.getCmp('updateButton').setDisabled(false);
                                        	}
                                        }
                                     }, 
                                     selModel: {
                                         selType: 'checkboxmodel'
                                        
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
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            dataIndex: 'Status',
                                            text: 'Status'
                                        }
                                    ],
                                    viewConfig: {
                                        height: 400
                                    }
                                },
                                {
                                    xtype: 'button',
                                    id: 'updateButton',
                                    itemId: 'updateButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    margin: '0 10 0 0',
                                    text: 'Update',
                                    disabled: true,
                                    listeners: {
                                        'beforerender' : function() {
                                        	 Ext.Ajax.request({
                                  				url : 'user/getAuth',
                                  				method : 'POST',
                                  				scope : this,
                                  				success : function(response) {
                                  					if(response.responseText == "3") Ext.getCmp('updateButton').hide();
                                  				}
                                  			});	
                                        }
                                    }
                                },
                                {
                                    xtype: 'button',
                                    id: 'deleteButton',
                                    itemId: 'deleteButton',
                                    allowDepress: false,
                                    scale: 'medium',
                                    text: 'Delete',
                                    listeners: {
                                        'beforerender' : function() {
                                        	 Ext.Ajax.request({
                                  				url : 'user/getAuth',
                                  				method : 'POST',
                                  				scope : this,
                                  				success : function(response) {
                                  					if(response.responseText == "3") Ext.getCmp('deleteButton').hide();
                                  				}
                                  			});	
                                        }
                                    }
                                },
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
                                    store: 'CntrDetailsStore',
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
                                        height: 400
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
    	}
        ]
});