/*
 * File: app/view/MainController.js
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

Ext.define('Booking.view.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.bkgdtlviewport',
    id: 'MainControllerId',
    action: null,
    bkgNum: null,
    afterRender: function(){
    	var bkgView = Ext.getCmp('BkgDtlViewportId');
    	if(bkgView.action=="update"){
    		var bkg = bkgView.bkg[0].data;
    		this.action = bkgView.action;
        	console.log(bkg);
        	
        	var bkgNum = Ext.getCmp('BkgNumId');
        	var bkgConId = Ext.getCmp('BkgConId');
        	var bkgShpId = Ext.getCmp('BkgShpId');
        	var bkgFrmCityid = Ext.getCmp('BkgFrmCityid');
        	var bkgToCityId = Ext.getCmp('BkgToCityId');
        	var cgoNatId = Ext.getCmp('CgoNatId');
        	var cgoDescId = Ext.getCmp('CgoDescId');
        	var cntrInfoGridId = Ext.getCmp('CntrInfoGridId');
        	
//        	console.log(cgoNatId);
        	var containers = bkg.ContainerDetails;
        	var cgoNat = { 'cgoNat' : bkg.ContainerDetails[0].cargoNature };
        	console.log(containers);
        	bkgNum.setValue(bkg.BkgNum);
        	bkgConId.setValue(bkg.Consignee);
        	bkgShpId.setValue(bkg.Shipper);
        	bkgFrmCityid.setValue(bkg.From);
        	bkgToCityId.setValue(bkg.To);
        	cgoNatId.setValue(cgoNat);
        	cgoDescId.setValue(containers[0].cargoDesc);
        	cntrInfoGridId.store.removeAll();
        	
        	for(i=0; i<containers.length; i++){
        		unit = containers[i].unit=='0' ? 'lbs' : 'KG';
        		data = { CntrType: containers[i].containerType, CntrNet: containers[i].grossWeight, CntrGross: containers[i].grossWeight, CntrUnit: unit, CntrNumber: containers[i].containerNum};
        		cntrInfoGridId.store.add(data);
        	}
    	}
    },

    onCntrInfoAdd: function(button, e, eOpts) {
        Ext.getBody().mask();
        Ext.create('Ext.window.Window', {
            title: 'Container Info',
            // layout: 'fit',
            id: 'CntrInfoWindowAdderId',
            layout: {
                type: 'vbox',
                align: 'stretch'
                // padding: '10'
            },
            listeners: {
                close: {
                    scope: this,
                    fn: function () {
                        Ext.getBody().unmask();
                    }
                },
                show: {
                    scope: this,
                    fn: function () {
                        var cntrUnit = Ext.getCmp('containrWgtUnitId');
                        var unitStore = cntrUnit.getStore().getRange();
                        cntrUnit.setValue(unitStore[0].data.code)
                    }
                }
            },
            items: [
            {
                xtype: 'container',
                id: 'CntrInfoWndowId',
                padding: '10',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Container Type',
                    allowBlank: false,
                    displayField: 'code',
                    forceSelection: true,
                    queryMode: 'local',
                    store: 'CntrTypeStore',
                    valueField: 'code'
                },
                {
                    xtype: 'numberfield',
                    id: 'containrNetWgtId',
                    fieldLabel: 'Container Net Weight',
                    maxValue: 999999.99,
                    minValue: 0,
                    decimalPrecision: 2
                },
                {
                    xtype: 'numberfield',
                    id: 'containrGrossWgtId',
                    fieldLabel: 'Container Gross Weight',
                    maxValue: 999999.99,
                    minValue: 0,
                    decimalPrecision: 2
                },
                {
                    xtype: 'combobox',
                    id: 'containrWgtUnitId',
                    fieldLabel: 'Container Weight Unit',
                    allowBlank: false,
                    displayField: 'name',
                    forceSelection: true,
                    queryMode: 'local',
                    store: 'CntrWgtUntStore',
                    valueField: 'code',
                    listeners: {
                        select: {
                            scope: this,
                            fn: function() {
                              var containrUnitCmp = Ext.getCmp('containrWgtUnitId');
                              var containrUnitVal = containrUnitCmp.getValue();
                              var grossCmp = Ext.getCmp('containrGrossWgtId');
                              var grossVal = grossCmp.getValue();
                              var netCmp = Ext.getCmp('containrNetWgtId');
                              var netVal = netCmp.getValue();
                              
                              console.log(containrUnitVal + ' ' + grossVal + ' ' + netVal);
                              //KG to pounds (1KG -> 2.204lbs)
                              if(containrUnitVal == 'KG'){
                                  if(!Ext.isEmpty(grossVal)){
                                      grossCmp.setValue((grossVal*2.204));
                                  }
                                  if(!Ext.isEmpty(netVal)){
                                      netCmp.setValue((netVal*2.204));
                                  }
                              }else if(containrUnitVal == 'lbs'){
                                  if(!Ext.isEmpty(grossVal)){
                                      grossCmp.setValue((grossVal/2.204));
                                  }
                                  if(!Ext.isEmpty(netVal)){
                                      netCmp.setValue((netVal/2.204));
                                  }
                              }
                            }
                        }
                    }
                }]
            },
            {
                xtype: 'container',
                padding: '0 0 10 10',
                layout: {
                    type: 'hbox',
                    align: 'stretch'
                },
                items: [{
                    xtype: 'button',
                    text: 'Save',
                    listeners: {
                        click: {
                            scope: this,
                            fn: function () {
                                var cmp = Ext.getCmp('CntrInfoWndowId');
                                var containerCmp = cmp.items.getRange();
                                var store = Ext.getStore('CntrStore');
                                var errors = [], data = [];
                                var cntrType, cntrNet, cntrGross, cntrUnit;

                                // Get component errors
                                for(var i=0; i<containerCmp.length; i++){
                                    if(!Ext.isEmpty(containerCmp[i].getErrors())){
                                        errors.push(containerCmp[i].getErrors());
                                    }
                                }
                                if(errors.length > 0 ){
                                    var isMissingField = false;
                                    errors.forEach(function(i){
                                        if(i=='This field is required'){
                                            isMissingField = true;
                                        }
                                    });
                                    if(isMissingField){
                                        Ext.MessageBox.alert('Warning!','Please fill up all fields to add!');
                                    }else{
                                        Ext.MessageBox.alert('Warning!','Please correct all invalid fields!');
                                    }
                                }else{
                                    for(var x=0; x<containerCmp.length; x++){
                                        // data.push(containerCmp[x].getValue());
                                        if(x===0){
                                            cntrType = containerCmp[x].getValue();
                                        }else if(x===1){
                                            cntrNet = containerCmp[x].getValue();
                                        }else if(x===2){
                                            cntrGross = containerCmp[x].getValue();
                                        }else if(x===3){
                                            cntrUnit = containerCmp[x].getValue();
                                        }
                                    }
                                    data.push({CntrType:cntrType, CntrNet:cntrNet,
                                    CntrGross:cntrGross, CntrUnit:cntrUnit, CntrNumber: ''});
                                    store.add(data);
                                }
                            }
                        }
                    }
                }]
            }]
        }).show();
    },
    
    onCntrInfoUpd: function(button, e, eOpts) {
    	if(Ext.isEmpty(Ext.getCmp("CntrInfoGridId").getSelection())){
    		Ext.Msg.alert('Alert', 'Please select a record to update');
    	}else{
    		Ext.getBody().mask();
            Ext.create('Ext.window.Window', {
                title: 'Container Info',
                // layout: 'fit',
                id: 'CntrInfoWindowUpdaterId',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                    // padding: '10'
                },
                listeners: {
                    close: {
                        scope: this,
                        fn: function () {
                            Ext.getBody().unmask();
                        }
                    },
                    show: {
                        scope: this,
                        fn: function () {
                        	var selected = Ext.getCmp('CntrInfoGridId').getSelection()[0];
                        	console.log(selected);
                        	var cntrSzeTyp = Ext.getCmp('containrSizeTypeId');
                        	cntrSzeTyp.setValue(selected.data.CntrType);
                            var cntrUnit = Ext.getCmp('containrWgtUnitId');
                            cntrUnit.setValue(selected.data.CntrUnit);
                        }
                    }
                },
                items: [
                {
                    xtype: 'container',
                    id: 'CntrInfoWndowId',
                    padding: '10',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [{
                        xtype: 'combobox',
                        id: 'containrSizeTypeId',
                        fieldLabel: 'Container Type',
                        allowBlank: false,
                        displayField: 'code',
                        forceSelection: true,
                        queryMode: 'local',
                        store: 'CntrTypeStore',
                        valueField: 'code'
                    },
                    {
                        xtype: 'numberfield',
                        id: 'containrNetWgtId',
                        fieldLabel: 'Container Net Weight',
                        maxValue: 999999.99,
                        minValue: 0,
                        value: Ext.getCmp("CntrInfoGridId").getSelection()[0].data.CntrNet,
                        decimalPrecision: 2
                    },
                    {
                        xtype: 'numberfield',
                        id: 'containrGrossWgtId',
                        fieldLabel: 'Container Gross Weight',
                        maxValue: 999999.99,
                        minValue: 0,
                        value: Ext.getCmp("CntrInfoGridId").getSelection()[0].data.CntrGross,
                        decimalPrecision: 2
                    },
                    {
                        xtype: 'combobox',
                        id: 'containrWgtUnitId',
                        fieldLabel: 'Container Weight Unit',
                        allowBlank: false,
                        displayField: 'name',
                        forceSelection: true,
                        queryMode: 'local',
                        store: 'CntrWgtUntStore',
                        valueField: 'code',
                        listeners: {
                            select: {
                                scope: this,
                                fn: function() {
                                  var containrUnitCmp = Ext.getCmp('containrWgtUnitId');
                                  var containrUnitVal = containrUnitCmp.getValue();
                                  var grossCmp = Ext.getCmp('containrGrossWgtId');
                                  var grossVal = grossCmp.getValue();
                                  var netCmp = Ext.getCmp('containrNetWgtId');
                                  var netVal = netCmp.getValue();
                                  
                                  console.log(containrUnitVal + ' ' + grossVal + ' ' + netVal);
                                  //KG to pounds (1KG -> 2.204lbs)
                                  if(containrUnitVal == 'KG'){
                                      if(!Ext.isEmpty(grossVal)){
                                          grossCmp.setValue((grossVal*2.204));
                                      }
                                      if(!Ext.isEmpty(netVal)){
                                          netCmp.setValue((netVal*2.204));
                                      }
                                  }else if(containrUnitVal == 'lbs'){
                                      if(!Ext.isEmpty(grossVal)){
                                          grossCmp.setValue((grossVal/2.204));
                                      }
                                      if(!Ext.isEmpty(netVal)){
                                          netCmp.setValue((netVal/2.204));
                                      }
                                  }
                                }
                            }
                        }
                    }]
                },
                {
                    xtype: 'container',
                    padding: '0 0 10 10',
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [{
                        xtype: 'button',
                        text: 'Save',
                        listeners: {
                            click: {
                                scope: this,
                                fn: function () {
                                	//Window component
                                    var cmp = Ext.getCmp('CntrInfoWndowId');
                                    var containerCmp = cmp.items.getRange();
                                    
                                    //Grid panel component
                                	var cntrGrid = Ext.getCmp('CntrInfoGridId').getView();
                                	var sel = cntrGrid.getSelection();
                                    var cntrGridStore = cntrGrid.getStore().getRange();
                                    
                                    var errors = [], data = [];
                                    var cntrType, cntrNet, cntrGross, cntrUnit;

                                    // Get component errors
                                    for(var i=0; i<containerCmp.length; i++){
                                        if(!Ext.isEmpty(containerCmp[i].getErrors())){
                                            errors.push(containerCmp[i].getErrors());
                                        }
                                    }
                                    if(errors.length > 0 ){
                                        var isMissingField = false;
                                        errors.forEach(function(i){
                                            if(i=='This field is required'){
                                                isMissingField = true;
                                            }
                                        });
                                        if(isMissingField){
                                            Ext.MessageBox.alert('Warning!','Please fill up all fields to add!');
                                        }else{
                                            Ext.MessageBox.alert('Warning!','Please correct all invalid fields!');
                                        }
                                    }else{                                        
                                        for(var x=0; x<cntrGridStore.length; x++){
                                        	if(cntrGridStore[x].get('id') == sel[0].get('id')){
                                        		for(var y=0; y<containerCmp.length; y++){
                                                    // data.push(containerCmp[x].getValue());
                                                    if(y==0){
                                                    	cntrGridStore[x].data.CntrType =  containerCmp[y].getValue();
                                                    }else if(y==1){
                                                    	cntrGridStore[x].data.CntrNet =  containerCmp[y].getValue();
                                                    }else if(y==2){
                                                    	cntrGridStore[x].data.CntrGross =  containerCmp[y].getValue();
                                                    }else if(y==3){
                                                    	cntrGridStore[x].data.CntrUnit =  containerCmp[y].getValue();
                                                    }
                                                }
                                        	}
                                        }
                                        cntrGrid.refresh();
                                        Ext.getCmp('CntrInfoWindowUpdaterId').close();
                                    }
                                }
                            }
                        }
                    }]
                }]
            }).show();
    	}
    },

    onCntrInfoDel: function(button, e, eOpts) {
        var cmp = Ext.getCmp('CntrInfoGridId');
        var selected = cmp.getSelection();
        var store = Ext.getStore('CntrStore');
        
        if(!Ext.isEmpty(selected)){
            store.remove(selected);
            // To remove all selected
            // store.removeAll(selected);
        }
    },

    onBkgSave: function(button, e, eOpts) {
    	// Container Details
        var cntrList = Ext.getStore("CntrStore").getRange();
        var containers = [];
        for(var i = 0; i< cntrList.length; i++){
        	containers.push(cntrList[i].data);
        }
        
        // Booking Validation Details
        var valWgt = Ext.getCmp('validWgtId').getValue();
        var appDoc = Ext.getCmp('ApproveDocId').getValue();
        var goodCus = Ext.getCmp('GoodCusId').getValue();
        var isBkgApprove = false;
        
        if(valWgt && appDoc && goodCus){
        	isBkgApprove = true;
        }
        
        
        // Booking Details
        var booking = {
        	consignee : Ext.getCmp('BkgConId').getValue(),
        	shipper : Ext.getCmp('BkgShpId').getValue(),
        	fromCity : Ext.getCmp('BkgFrmCityid').getValue()==null?'':Ext.getCmp('BkgFrmCityid').getValue(),
        	toCity :  Ext.getCmp('BkgToCityId').getValue()==null?'':Ext.getCmp('BkgToCityId').getValue(),
        	cargoNature : Ext.isEmpty(Ext.getCmp('CgoNatId').getValue().cgoNat)?'':Ext.getCmp('CgoNatId').getValue().cgoNat,
        	description : Ext.getCmp('CgoDescId').getValue(),
        	validWgt : valWgt,
        	approveDoc : appDoc,
        	goodCustomer : goodCus,
        	bkgStat : isBkgApprove
        }
        
        if(this.action=="update"){
        	booking.bkgNum = Ext.getCmp('BkgNumId').getValue();
            console.log("bkg num");
            console.log(booking.bkgNum);
        }
        
        //validate booking details
        console.log(this.validateBookingOnSave(booking, containers));
        var validateResult = this.validateBookingOnSave(booking, containers);
        if(validateResult.isSave){
        	Ext.Ajax.request({
    			url : (this.action==null ? 'booking/saveBkg' : 'booking/updateBkg'),
    			method : 'POST',
    			params : {
    				booking : Ext.util.JSON.encode(booking),
    				containers : Ext.util.JSON.encode(containers)
    			},
    			scope : this,
    			success : function(response) {
    				console.log("saved!");
    				var resData = Ext.util.JSON.decode(response.responseText);
    				if(resData.success){
    					if(this.action==null){
        					Ext.Msg.alert('Booking Number','Booking #'+resData.bkgNum+' has been created successfuly.');
    					}
    					else{
        					Ext.Msg.alert('Booking Number','Booking #'+resData.bkgNum+' has been successfuly updated.');
    					}
    				}
    			}
    		});
        }else{
        	
        	Ext.Msg.alert('Validation Result',validateResult.error);
        }        
    },
    
    validateBookingOnSave: function(booking, containers) {
    	var bkgValidation = {
        	isSave : true,
        	error : ''
        };
    	
    	//validate if empty
    	if(Ext.isEmpty(booking.consignee)){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please complete all required fields!';
    		return bkgValidation
    	}else if(Ext.isEmpty(booking.shipper)){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please complete all required fields!';
    		return bkgValidation
    	}else if(Ext.isEmpty(booking.fromCity)){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please complete all required fields!';
    		return bkgValidation
    	}else if(Ext.isEmpty(booking.toCity)){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please complete all required fields!';
    		return bkgValidation
    	}else if(Ext.isEmpty(booking.cargoNature)){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please complete all required fields!';
    		return bkgValidation
    	}else if(Ext.isEmpty(booking.description)){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please complete all required fields!';
    		return bkgValidation
    	}else if(containers.length<1){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'Please enter at least one container! We can\'t ship nothing!';
    		return bkgValidation
    	}
    	
    	//validate if from and to city is same
    	if(booking.fromCity == booking.toCity){
    		bkgValidation.isSave = false;
    		bkgValidation.error = 'FROM and TO city must not be the same';
    		return bkgValidation
    	}
    	
    	return bkgValidation;
    },
    
    onBkgCancel: function(button, e, eOpts) {
    	Ext.getCmp('SearchBookingView').show();
    	Ext.getCmp('BkgDtlViewportId').destroy();
    }

});
