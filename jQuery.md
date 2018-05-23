# jQuery Cheatsheet

## Document ready
```js
$(document).ready(function(){});
$(function(){});  // shorthand: same as above
```

## Built-in animations
```js
.show();
.hide();
.fadeTo('fast', <opacity value>); //  'fast' 'slow' or speed in ms
.fadeIn('fast');
.fadeOut('fast');
.animate({left:'+=10px'}, 'fast');
.slideToggle();
```

## DOM manipulation
```js
.prepend('<HTML element>');
.append('<HTML element>');
('<HTML element>').prependTo('<selector>')
('<HTML element>').appendTo('<selector>')
var $p = $("p");      // existing element
.after($p);           // moves $p to position after selector
.after($("p"));       // Same as above
.empty();             // deletes an element's content and all its descendants. For instance, if you .empty() an 'ol', you'll also remove all its 'li's and their text.
.remove();            // not only deletes an element's content, but deletes the element itself.
.html();              // get the contents of the first element match it finds
.html("I love jQuery!");  // get the HTML contents of the first div it finds, and set the contents of the first div it finds to "I love jQuery!"
```

## CSS manipulation
```js
.addClass('className');
.removeClass('className');
.toggleClass('className');  // toggles className
.height("100px");
.width("50px");
.css("background-color","#008800");
```
## Forms
```js
$('input:checkbox:checked').val(); // .val() is used to get the value of form elements
var input = $('input[name=checkListItem]').val();
```
## Binding
### on
For use when there is a need to bind actions on dom elements which are not yet present on document load
events:
```js
$(document).on('event', 'selector', function() {
    $(this) // Do something!
});
.mouseenter();
.click();
.dblclick();
.hover(
   // mouse in
   function(){
      $(this).addClass('highlight');
   },
   // mouse out
   function(){
      $(this).removeClass('highlight');
   }
);
.focus(); // only works on elements that can receive focus i.e elements like <textarea> and <input>
.keydown(function(key){});  // listens for keystrokes within the selector container
```
  
## jQuery UI
Documentation at http://jqueryui.com/*/
````html
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
.effect('<effect>');
  .effect('explode');
  .effect('bounce', {times:2}, 200),
  .effect('slide')
.accordion({collapsible: true, active: false});
.sortable();
.draggable();
.resizable();
.selectable();	// need CSS defintion for .ui-selected
```
