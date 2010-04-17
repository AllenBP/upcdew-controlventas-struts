function CalendarObject(){
this.DOMINGO=1;
this.LUNES=2;
this.MARTES=3;
this.MIERCOLES=4;
this.JUEVES=5;
this.VIERNES=6;
this.SABADO=7;
this.ENERO=1;
this.FEBRERO=2;
this.MARZO=3;
this.ABRIL=4;
this.MAYO=5;
this.JUNIO=6;
this.JULIO=7;
this.AGOSTO=8;
this.SEPTIEMBRE=9;
this.OCTUBRE=10;
this.NOVIEMBRE=11;
this.DICIEMBRE=12;
}
var Calendar=new CalendarObject();
var esMonthMMM=new Array("Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic");
var esMonthMMMM=new Array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
var monthLastDate=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
var esWeekDayEEE=new Array("Dom","Lun","Mar","Mie","Jue","Vie","Sab");
var esWeekDayEEEE=new Array("Domingo","Lunes","Martes","Mi\xe9rcoles","Jueves","Viernes","S\xe1bado");
function getNombreMesMMM(_1){
if(_1>=1&&_1<=12){
return esMonthMMM[_1-1];
}else{
return "inv\xe1lido";
}
}
function getNombreMesMMMM(_2){
if(_2>=1&&_2<=12){
return esMonthMMMM[_2-1];
}else{
return "inv\xe1lido";
}
}
function getNombreDiaSemanaEEE(_3){
if(_3>=1&&_3<=7){
return esWeekDayEEE[_3-1];
}else{
return "inv\xe1lido";
}
}
function getNombreDiaSemanaEEEE(_4){
if(_4>=1&&_4<=7){
return esWeekDayEEEE[_4-1];
}else{
return "inv\xe1lido";
}
}
function parseDate(_5,_6){
var _7=new Date();
if(_5=="dd/MM/yyyy"){
_7.setYear(_6.substring(6,10));
_7.setMonth(_6.substring(3,5)-1);
_7.setDate(_6.substring(0,2));
}
if(_5=="dd MMM yyyy"){
_7.setYear(_6.substring(7,11));
_7.setMonth(esMonthMMM.indexOf(_6.substring(3,6)));
_7.setDate(_6.substring(0,2));
}
if(_5=="dd MMMM yyyy"){
_7.setYear(_6.substring(_5.length-4,_5.length));
_7.setMonth(esMonthMMM.indexOf(_6.substring(3,_5.indexOf(" ",3))));
_7.setDate(_6.substring(0,2));
}
if(_5=="dd/MM/yyyy HH:mm:ss"){
_7.setYear(_6.substring(6,10));
_7.setMonth(_6.substring(3,5)-1);
_7.setDate(_6.substring(0,2));
_7.setHours(_6.substring(11,13));
_7.setMinutes(_6.substring(14,16));
_7.setSeconds(_6.substring(17,19));
}
return _7;
}
function formatDate(_8,_9){
var _a="";
if(_8=="dd/MM/yyyy"){
_a+=(_9.getDate()<10)?"0"+_9.getDate():_9.getDate();
_a+="/";
_a+=((_9.getMonth()+1)<10)?"0"+(_9.getMonth()+1):(_9.getMonth()+1);
_a+="/";
_a+=_9.getFullYear();
}
if(_8=="dd MMM yyyy"){
_a+=(_9.getDate()<10)?"0"+_9.getDate():_9.getDate();
_a+=" ";
_a+=esMonthMMM[_9.getMonth()];
_a+=" ";
_a+=_9.getFullYear();
}
if(_8=="dd MMMM yyyy"){
_a+=(_9.getDate()<10)?"0"+_9.getDate():_9.getDate();
_a+=" ";
_a+=esMonthMMMM[_9.getMonth()];
_a+=" ";
_a+=_9.getFullYear();
}
if(_8=="dd/MM/yyyy HH:mm:ss"){
_a+=(_9.getDate()<10)?"0"+_9.getDate():_9.getDate();
_a+="/";
_a+=((_9.getMonth()+1)<10)?"0"+(_9.getMonth()+1):(_9.getMonth()+1);
_a+="/";
_a+=_9.getFullYear();
_a+=" ";
_a+=(_9.getHours()<10)?"0"+_9.getHours():_9.getHours();
_a+=":";
_a+=(_9.getMinutes()<10)?"0"+_9.getMinutes():_9.getMinutes();
_a+=":";
_a+=(_9.getSeconds()<10)?"0"+_9.getSeconds():_9.getSeconds();
}
return _a;
}
function getDaysOfMonth(_b,_c){
if(_b>=1&&_b<=12){
if(_b==2){
if(isLeapYear(_c)){
return 29;
}
}
return monthLastDate[_b-1];
}else{
return -1;
}
}
function isLeapYear(_d){
if(_d%4==0){
if(_d%100==0&&_d%400!=0){
return false;
}
return true;
}else{
return false;
}
}
function compararFechas(_e,_f){
if(_e.getTime()==_f.getTime()){
return 0;
}else{
if(_e.getTime()<_f.getTime()){
return -1;
}else{
return 1;
}
}
}
Date.prototype.before=function(_10){
if(compararFechas(this,_10)<0){
return true;
}else{
return false;
}
};
Date.prototype.after=function(_11){
if(compararFechas(this,_11)>0){
return true;
}else{
return false;
}
};
function getFechaSumadosMinutos(_12,_13){
var _14=new Date();
_14.setTime(_12.getTime());
_14.setMinutes(_14.getMinutes()+_13);
return _14;
}
function getFechaSumadosSegundos(_15,_16){
var _17=new Date();
_17.setTime(_15.getTime());
_17.setSeconds(_17.getSeconds()+_16);
return _17;
}
function getDiferenciaDias(_18,_19){
var _1a=_19.getTime()-_18.getTime();
var _1b=Math.floor(_1a/(1000*60*60*24));
return _1b;
}
function parseFechaDeCombosFecha(_1c,_1d){
with(document.forms[_1c]){
var _1e=elements[_1d+"Fecha"].options[elements[_1d+"Fecha"].selectedIndex].value;
var _1f=elements[_1d+"Mes"].options[elements[_1d+"Mes"].selectedIndex].value;
var _20=elements[_1d+"Anio"].options[elements[_1d+"Anio"].selectedIndex].value;
var _21=new Date();
_21.setYear(_20);
_21.setMonth(_1f);
_21.setDate(_1e);
return _21;
}
}
function parseFechaDeCombosFechaSinFecha(_22,_23){
with(document.forms[_22]){
var _24=elements[_23+"Mes"].options[elements[_23+"Mes"].selectedIndex].value;
var _25=elements[_23+"Anio"].options[elements[_23+"Anio"].selectedIndex].value;
var _26=new Date();
_26.setYear(_25);
_26.setMonth(_24);
_26.setDate(1);
return _26;
}
}
function actualizarFechaDeCombosFecha(_27,_28,_29){
var _2a=new Array();
var _2b=1;
with(document.forms[_27]){
if(elements[_28+"Fecha"].selectedIndex!=-1){
_2b=elements[_28+"Fecha"].options[elements[_28+"Fecha"].selectedIndex].value;
}
}
var len=getDaysOfMonth(_29.getMonth()+1,_29.getFullYear());
for(i=0;i<len;i++){
_2a[i]=new SelectDataObj(i+1,i+1);
}
actualizarComboBox(_27,_28+"Fecha",null,_2a,null,null,null);
if(_2b<=len){
with(document.forms[_27]){
elements[_28+"Fecha"].selectedIndex=_2b-1;
}
}
}
function actualizarMesDeCombosFecha(_2d,_2e){
var _2f=new Array();
for(i=0;i<12;i++){
_2f[i]=new SelectDataObj(i+1,esMonthMMMM[i]);
}
actualizarComboBox(_2d,_2e+"Mes",null,_2f,null,null,null);
}
function eventoCambioCombosFechaFecha(_30,_31){
var _32=parseFechaDeCombosFecha(_30,_31);
document.forms[_30].elements["hid"+_31.substring(3,_31.length)].value=_32.getTime();
}
function eventoCambioCombosFecha(_33,_34){
var _35=parseFechaDeCombosFechaSinFecha(_33,_34);
actualizarFechaDeCombosFecha(_33,_34,_35);
_35=parseFechaDeCombosFecha(_33,_34);
document.forms[_33].elements["hid"+_34.substring(3,_34.length)].value=_35.getTime();
}
function setValorComboFecha(_36,_37,_38){
if(getFormElement(_36,"cmbFecha"+_37+"Fecha")!=null){
selectFieldComboByValue(_36,"cmbFecha"+_37+"Anio",_38.getFullYear(),true);
selectFieldComboByValue(_36,"cmbFecha"+_37+"Mes",_38.getMonth(),true);
selectFieldComboByValue(_36,"cmbFecha"+_37+"Fecha",_38.getDate(),false);
eventoCambioCombosFechaFecha(_36,"cmbFecha"+_37);
}
}
function setValorComboFechaDia(_39,_3a,_3b){
if(getFormElement(_39,"cmbFecha"+_3a+"Fecha")!=null){
selectFieldComboByValue(_39,"cmbFecha"+_3a+"Fecha",_3b.getDate(),false);
}
}
function setValorComboFechaMes(_3c,_3d,_3e){
if(getFormElement(_3c,"cmbFecha"+_3d+"Fecha")!=null){
selectFieldComboByValue(_3c,"cmbFecha"+_3d+"Mes",_3e.getMonth(),true);
}
}
function setValorComboFechaAnio(_3f,_40,_41){
if(getFormElement(_3f,"cmbFecha"+_40+"Fecha")!=null){
selectFieldComboByValue(_3f,"cmbFecha"+_40+"Anio",_41.getFullYear(),true);
}
}
function getValorComboFecha(_42,_43){
return parseFechaDeCombosFecha(_42,"cmbFecha"+_43);
}
function getValorComboFechaDia(_44,_45){
with(document.forms[_44]){
var _46=elements["cmbFecha"+_45+"Fecha"].options[elements["cmbFecha"+_45+"Fecha"].selectedIndex].value;
var _47=((_46<10)?"0"+_46:_46);
return _47;
}
}
function getValorComboFechaMes(_48,_49){
with(document.forms[_48]){
var _4a=elements["cmbFecha"+_49+"Mes"].options[elements["cmbFecha"+_49+"Mes"].selectedIndex].value;
var _4b=new Date();
_4b.setMonth(_4a);
var _4c=(((_4b.getMonth()+1)<10)?"0"+(_4b.getMonth()+1):(_4b.getMonth()+1));
return _4c;
}
}
function getValorComboFechaAnio(_4d,_4e){
with(document.forms[_4d]){
var _4f=elements["cmbFecha"+_4e+"Anio"].options[elements["cmbFecha"+_4e+"Anio"].selectedIndex].value;
return _4f;
}
}
function getNombreComboFechaAnio(_50){
return "cmbFecha"+_50+"Anio";
}
function getNombreComboFechaMes(_51){
return "cmbFecha"+_51+"Mes";
}
function getNombreComboFechaDia(_52){
return "cmbFecha"+_52+"Fecha";
}
function getComboHoraHora(_53,_54){
return getFormElement(_53,"cmbHora"+_54+"Hora");
}
function getComboHoraMinuto(_55,_56){
return getFormElement(_55,"cmbHora"+_56+"Minuto");
}
function getComboHoraSegundo(_57,_58){
return getFormElement(_57,"cmbHora"+_58+"Segundo");
}
function getNombreComboHoraHora(_59){
return "cmbHora"+_59+"Hora";
}
function getNombreComboHoraMinuto(_5a){
return "cmbHora"+_5a+"Minuto";
}
function getNombreComboHoraSegundo(_5b){
return "cmbHora"+_5b+"Segundo";
}
function enableComboHora(_5c,_5d){
if(getNombreComboHoraHora(_5d)!=null){
enableFormElement(_5c,getNombreComboHoraHora(_5d));
enableFormElement(_5c,getNombreComboHoraMinuto(_5d));
enableFormElement(_5c,getNombreComboHoraSegundo(_5d));
}
}
function disableComboHora(_5e,_5f){
if(getNombreComboHoraHora(_5f)!=null){
disableFormElement(_5e,getNombreComboHoraHora(_5f));
disableFormElement(_5e,getNombreComboHoraMinuto(_5f));
disableFormElement(_5e,getNombreComboHoraSegundo(_5f));
}
}
function getComboHoraTiempo(_60,_61){
if(getNombreComboHoraHora(_61)!=null){
var _62=new Date();
_62.setHours(getComboHoraHora(_60,_61).value);
_62.setMinutes(getComboHoraMinuto(_60,_61).value);
_62.setSeconds(getComboHoraSegundo(_60,_61).value);
return _62;
}else{
return null;
}
}
function setComboHoraTiempo(_63,_64,_65){
if(getNombreComboHoraHora(_64)!=null){
if(getComboHoraHora(_63,_64).options){
selectFieldComboByValue(_63,getNombreComboHoraHora(_64),_65.getHours(),false);
}
if(getComboHoraMinuto(_63,_64).options){
selectFieldComboByValue(_63,getNombreComboHoraMinuto(_64),_65.getMinutes(),false);
}
if(getComboHoraSegundo(_63,_64).options){
selectFieldComboByValue(_63,getNombreComboHoraSegundo(_64),_65.getSeconds(),false);
}
}
}

