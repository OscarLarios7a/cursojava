self.onmessage=function(event){
  self.postMessage("You wrote: " + event.data);
};