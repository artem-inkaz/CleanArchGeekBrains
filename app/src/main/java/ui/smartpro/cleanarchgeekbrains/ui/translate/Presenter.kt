package ui.smartpro.cleanarchgeekbrains.ui.translate

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.plusAssign
import ui.smartpro.cleanarchgeekbrains.common.AppState
import ui.smartpro.cleanarchgeekbrains.common.BasePresenter
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem
import ui.smartpro.geekbrainskursovoimvp.scheduler.DefaultSchedulers

class PresenterImpl(
    private val interactor: Interactor,
    protected val schedulers: DefaultSchedulers = DefaultSchedulers()
):
    BasePresenter<AppState,Contract.View>(),Contract.Presenter {

    private val disposables = CompositeDisposable()

    private var currentView: Contract.View? = null

    override fun getTranslate(word: String): Observable<List<ResponseItem>> {
        return interactor
            .getTranslate(word).toObservable()
    }
    override fun getData(word: String, isOnline: Boolean) {
        disposables +=
            interactor
                .getTranslate(word)
                .subscribeOn(schedulers.background())
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    {currentView?.showBikes(it)},{}
                )
    }

    override fun attach(view: Contract.View) {
        super.attach(view)
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detach(view: Contract.View) {
        super.detach(view)
        disposables.clear()
        if (view == currentView) {
            currentView = null
        }
    }
}