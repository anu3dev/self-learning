class EventEmitter {
    constructor(){
        this.events = {};
    }

    on(eventName, listener){
        if(!this.events[eventName]){
            this.events[eventName] = [];
        }

        this.events[eventName].push(listener);
    }

    emit(eventName, ...args){
        if(!this.events[eventName]) return

        this.events[eventName].forEach(listener => {
            listener(...args);
        })
    }

    off(eventName, listener) {
        if (!this.events[eventName]) return

        this.events[eventName] = this.events[eventName].filter(
            l => l !== listener
        )
    }

    once(eventName, listener) {
        const wrapper = (...args) => {
            listener(...args)
            this.off(eventName, wrapper)
        }

        this.on(eventName, wrapper)
    }
}

const emitter = new EventEmitter()

const onMessage = (msg) => console.log("Received:", msg)

emitter.on("message", onMessage);
// emitter.emit("message", "Hello"); 
// Received: Hello

// emitter.off("message", onMessage);
// emitter.emit("message", "World"); 
// nothing happens

// emitter.once("login", user => console.log("Login:", user));
// emitter.emit("login", "Anurag");
// emitter.emit("login", "Anurag"); 
// ignored