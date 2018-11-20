
 Developed plugin for show android native dialog and display count down except loader (Spinner) image.
 
#Screenshots

<img src="https://dl.dropboxusercontent.com/s/dsyxioyr0znul7u/greenImage0.png?dl=0" alt="Count 0" width="160">
<img src="https://dl.dropboxusercontent.com/s/hi7dd67fritlovl/greenImage1.png?dl=0" alt="Count 1" width="160">
<img src="https://dl.dropboxusercontent.com/s/8y65sbasfcy9xf9/greenImage2.png?dl=0" alt="Count 2" width="160">
<img src="https://dl.dropboxusercontent.com/s/kljsbhdu38spy81/greenImage3.png?dl=0" alt="Count 3" width="160">

=============

## Installation

```
cordova plugin add https://github.com/simpson0303/cordova_plugin.git

```

## Local Path Installation

```
cordova plugin add cordova_plugin

```
## Methods
- `CountDownDialog.show`

- `CountDownDialog.hide`

#### Count Down Dialog show default
 ```
     CountDownDialog.show();
```
### Need to custom count down dialog :
  Change fontSize,fontColor,increase/decrease time and start form 1/0.
```
 var option = {"countTime":"12000",
                "fontSize":"150",
                "fontColor":"#FFF000",
                "isCountStartFormOne":"true"};
 CountDownDialog.show(option);

```
- __countTime__: Set time for count down up to  Optional ._(String)_
- __fontSize__: Set font size Optional. _(String)_
- __fontColor__: Set font color Optional. _(String)_
- __isCountStartFormOne__: Set true/false when start count down form 1/0 : _(String)_

#### CountDownDialog.hide

    CountDownDialog.hide();
    

#Screenshots Red Color

<img src="https://dl.dropboxusercontent.com/s/6z12p5z2bpctvks/redImage1.png?dl=0" alt="Count 0" width="180">
<img src="https://dl.dropboxusercontent.com/s/vvpaqcuu7uh0qwc/redImage2.png?dl=0" alt="Count 1" width="180">
<img src="https://dl.dropboxusercontent.com/s/pq4pk56gr3g2mcw/redImage3.png?dl=0" alt="Count 2" width="180">
<img src="https://dl.dropboxusercontent.com/s/2rytz6iatxysrzq/redImage4.png?dl=0" alt="Count 3" width="180">

simpson03031
1 0 LokeshPatel