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
        an immediate cancellation of all its children, which is a lot more convenient than if we had to 
        do this manually for each coroutine.
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
	(1) Adapter
	/*
	-> The adapter lets you convert one type of plug to another, which is really one interface 
		into another and make it work nicely. The adapter pattern in software engineering helps an object 
		to work together nicely with another API just like how a power adapter lets your laptop charge 
		when you are traveling.

	-> we built an adaptor which adapts our data into something that can be used by RecyclerView.
		Concretely, our data is stored in a room database. We'll build an adapter that adapts the data from
		the room database into something that Recyclerview knows how to display.
	*/
	(2) RecyclerView
	/*
	-> RecyclerView won't use data directly. In fact, it won't even know SleepNight exists.
		We will use adapter to expose or adapt the data into the RecyclerView API.
  */
  (3) inflate layout
  /*
  -> To inflate the layout from XML, you use a LayoutInflator, just like you did in activities or fragments.
      You can also create a LayoutInflater from any view or ViewGroup by passing to context. Here 
      we are saying LayoutInflater.from parent.context. That means you will create a LayoutInflater 
      based on the parent view. It's somewhat important to use the right context.

  -> Views know a lot about themselves and LayoutInflater uses that information to inflate new views correctly.
    If you just pass a random context here,for example, the application context, you might get views with 
    unexpected colors, forms or even sizes. Next, we just use the LayoutInflater object to inflate TextItemView.
  */
  (4) notifyDataSetChanged()
  /*
  -> NotifyDatasetChanged tells RecyclerView that the entire list is potentially invalid. As a result,
      RecyclerView has to re-bind and re-draw every item in the list. This is true even if the item that has 
      been updated isn't even on the screen right now. This can be really expensive, especially if you have 
      a complex list of items. It's easy for this to take long enough that it's visible to the user.
      
  -> NotifyDataSetChanged causes a lot of screen updates, which can lead to poor performance for your app.
    In extreme cases, this might show up as a flicker to the user as the screen updates. More likely,
    this will show up as a hiccup while scrolling.
  */
  (5) DiffUtil
  /*
  -> DiffUtil, for calculating diffs or differences between two lists. It will take an old list and the new list,
    and figure out what's different. It will find items that were added, removed, or changed.
    Then, it will use an algorithm called a Eugene W. Myers's difference algorithm to figure out the minimum number of changes 
    to make from the old list to produce the new list. That means, instead of adding an item and removing it 
    somewhere else, it will figure out that, you can just move it, for example.
  */
  (6) ListAdapter
  /*
  -> ListAdapter keeps track of the list for you and notifies the adapter when the list is updated. and even 
    notifying the adapter when the list is updated
  */
  (7) Binding Adapters 
  /*
  -> Binding adapters are adapters that take your data and adapt it into something that data binding 
    can use to bind a view, like text or an image
  
  -> The binding adapter is responsible for updating the view to represent the data
  */
  (8) executePendingBindings()
  /*
  -> This call is an optimization that asks data binding to execute any pending bindings right away.
  -> It's always a good idea to call executePendingBindings() when you use binding adapters in a RecyclerView,
    because it can slightly speed up sizing the views
  */
  (9) Header
  /*
  -> Recycler view displays a list of data and every item in the list corresponds to an index numbers 
    starting from zero.
  -> First Way: if you want to show a header at the top of the table, we need to return a view holder 
    for the header while link up to zero index item. Then all the other items would be mapped with 
    the header offset. So the sleep night object at the beginning of the list would end up in 
    the adapter position one. Continuing with the index increased by one for each element of the list.
  -> Second Way: Another way to add headers is to modify the pecking datasets for your data grid.
    you can modify the list to include items to represent a header.
  */

8- 
    (1) Web Servers
    /*
    -> Web servers today run Web services using a common stateless Web architecture known as REST,
      which stands for Representational State Transfer.
    -> Web services that offer this architecture are known as RESTful services.
    */
    (2) RESTful
    /*
    -> RESTful services are built using the standard Web components and protocols.Requests are made to 
      RESTful Web services in a standardized way via URIs. The familiar Web URL is actually a type of URI.

    -> Each Web services requests contains a URI and is transferred to our server using the same HTTP protocol 
      that's used by Web browsers. HTTP requests contain an operation to tell the server what to do. 
      Common HTTP operations include GET for retrieving server data,
    */
    (3)
    /*
    -> scalar converter. A library that allows retrofit to return the JSON result as a string.
    */
    (4) RetroFit
    /*
    -> RetroFit library creates URIs for the Web service based on the parameters we pass to it 
      so we can focus on app functionality.

    -> Retrofit is a library that creates a network API for our app based on the content from our web service.
      It fetches data from our web service and route it through a separate converter library that 
      knows how to decode the data and return it in a form of useful objects.

    -> Retrofit can support any data format returned from our web service with the right converter library
    
    > retrofit includes built-in support for libraries that parse popular web data formats, such as XML and JSON.
      After supplying retrofit with the right converter libraries
    */
    (5) Converter Factory
    /*
    -> converter factory, which builds converters in the correct format for the server response.
    -> allow retrofit to return the server response in useful format
    -> Moshi which parses JSON into Kotlin objects. Retrofit has a converter that works with Moshi
    */
    (6) Deferred
    /*
    -> deferred is a coroutine job that can directly return a result. As a reminder, a coroutine job 
      provides a way ofcanceling and determining the state of a coroutine. But unlike a job, deferred has a method 
      called await. Await is a suspend function on the deferred. It causes the code to await without blocking in
      true coroutines fashion until the value is ready, and then the value is returned.

    -> You can think of it this way. Retrofit will return a deferred and then you await the result which 
    has the appearance of synchronous code. If there's an error, await will return that by throwing an exception.
    */
    (7)   binding.executePendingBindings()
    /*
    -> Since we're calling bind() from onBindViewHolder(), having the bindings execute immediately 
      as a practice can prevent the RecyclerView from having to perform extra calculations 
      when it figures out how to display the list.
    */
    (8) Parceling  and Bundle
    /*
    -> parceling is a way of sharing objects between different processes by flattening an object into 
      a stream of data called a parcel. A complex object can be stored into the parcel and then recreated 
      from the parcel by implementing the parcelable interface, and they become parcelable objects. Each value 
      in the object is written in sequence to the parcel. The object is recreated by reading data from 
      the parcel in the same order it was written to populate data in a new object.

    -> A bundle is a parcelable object that contains a key value store of parcelable objects. We use 
      bundles as the argument property in fragments,
    */