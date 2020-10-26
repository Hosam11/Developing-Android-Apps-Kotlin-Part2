6- 
	(1)
    /*
    RoomDataBase:  this class is abstract coz room creates the implemntaion for it for us 
    */
    DataBaseClass
    /* 
    -> export schema: is true by default and saves the schema of the database to folder
        this provides you with verion history of your database which can be vert helpful for 
        complex databases that changes often
    -> why compain object
        sens the only purpos if this class is to provide us with a database there is no reason to 
        ever instantiate it
    -> Volatie
        help us make sure the value of instance is always up to data and the same to all execution threats
        the value of a Volatie will never be cached and all write and reads will be done to and from 
        main memory it means that changes made by one thread to instance are visible to all other threads immediatrly
    -> Synchronized
        means only one thread of exeution at a time can enter this block of code
    */
    (2) Merge
    //the merge tag can be used to eliminate redundant layout when including layouts
    (3) ViewModel and ViewModelFactory
    /*
    -> We need factory to instantiate the viewModel and provide it with data source
    -> From the Dao our viewModel knows how to access the database but we haven't created a referece to the database 
      that is we don't need the entire database object just the Dao that access the table we need
    -> We do need to  make sure there is a database when viewModel is created so instead of having the viewmodel 
      created dependency to the database the viewModelFactory provides this dependency to the viewModel 
      in this way the viewModel becomes easy to test
    */
    (4) Scheduler and Dispatcher
    /*
    -> Scheduler: takes into account things such as priorities and makes sure all the threads get to run and finish,
      No book is allowed to sit in a shelf forever and gather dust but is the book is very long
      or it can wait it may take a awhile before it gets sent to you away

    -> Dispatcher: that is it sends you book that you need to read and specifies a context for that to happen in
    */
    (5)  Callback Drawbacks
    /*
    -> Code become hard to read and harder to reason about
    -> don't allow use of some languages features such as exception
    -> There is no way to signal an error from long running task with exceptions when coding in the callback style 
      as flow control has already left the function that registerd to the callback because the callback 
      is not typically call by the application code, callback need to pass error via anthor exception handler 
      something called an airbag or a result object which cab be success or failure 
    */
    (6) Coroutuines
    /*
    -> coroutuines let you convert callback-based code to sequential code
      coroutuines and callback do exactly the same thing wait until the result is available from long-running task 
      and continue execution however, in code look very different
    */
    (7) Coroutines Characteristics
    /*
    -> asynchronous
      the coroutuine runs independently from the main exection steps of your program, this could be in parallel 
      on a separate proccessor but could also be that while the rest of the app is waiting for input 
      we sneak in a bit of proccessing
    -> non-blocking
    -> (sequential) use suspent function to make asynchronous code sequential
    -> the compliar will make sure the results are available before continuing or resuming
    */
    (8) Suspend
    /*
    -> other work happen until the resul is availble
    -> suspend dose not specify this thread code runs on, its may ron on a background thread or a domin thread
    */
    (9) To use Coroutines you need
    /* 
    -> Job
       - a job is anything that can be canceled, All coroutines have a job, and you can use it to cancel the coroutine.
       - Jobs can be arranged into parent-child hierarchies so that cancellation of a parent leads to 
        an immediate cancellation of all its children, which is a lot more convenient than if we 
        had to do this manually for each coroutine.
    -> Dispatcher 
       The dispatcher sends off coroutines to run on various threads.
       For example, dispatcher.main will run tasks on the main thread,
       and dispatcher.IO is for offloading blocking IO tasks to a shared pool of threads.
      
    -> Scope 
       - Scope combines information, including a job and dispatcher, to define the context in which the coroutine runs.
       - Scopes keep track of coroutines. When you launch a coroutine, it's in scope,
        which means that you've said which scope will keep track of the coroutine.
    */
    (10) ViewModelJob
    /*
    -> This viewModelJob allows us to cancel all coroutines started by this ViewModel when the ViewModel 
       is no longer used and destroyed so that we don't end up with coroutines that have nowhere to return to.
    -> When a ViewModel is destroyed, onCleared is called.
       We can override this method to cancel all coroutines started from the ViewModel.
    */
    (11) Get a Scope
    /*
    -> we need a scope for our coroutines to run in, The scope determines what thread the coroutine will run on,
       and it also needs to know about the job.
    */
    (12) About Dispatcher
    /*
    -> Dispatchers.Main means coroutines launched in the UI scope will run on the main thread.
       This is sensible for many coroutine started by a ViewModel, as they will eventually result 
       in an update of the UI after performing some processing,
    */

7- 
	(1) 
	/*
	-> The adapter lets you convert one type of plug to another, which is really one interface 
		into another and make it work nicely. The adapter pattern in software engineering helps an object 
		to work together nicely with another API just like how a power adapter lets your laptop charge 
		when you are traveling.

	-> we built an adaptor which adapts our data into something that can be used by RecyclerView.
		Concretely, our data is stored in a room database. We'll build an adapter that adapts the data from
		the room database into something that Recyclerview knows how to display.
	*/
	(2)
	/*
	-> RecyclerView won't use data directly. In fact, it won't even know SleepNight exists.
		We will use adapter to expose or adapt the data into the RecyclerView API.
	*/