package com.apps.dount_provider.mvvm;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.apps.dount_provider.model.PreviousOrderDataModel;
import com.apps.dount_provider.model.PreviousOrderModel;
import com.apps.dount_provider.remote.Api;
import com.apps.dount_provider.tags.Tags;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class FragmentPreviousOrderMvvm extends AndroidViewModel {
    private static final String TAG = "FragmentPrevOrderMvvm";
    private MutableLiveData<List<PreviousOrderModel>> onOrderDataSuccess;
    private MutableLiveData<Boolean> isLoadingLivData;
    private MutableLiveData<String> filterBy;

    private CompositeDisposable disposable = new CompositeDisposable();

    public FragmentPreviousOrderMvvm(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getIsLoading() {
        if (isLoadingLivData == null) {
            isLoadingLivData = new MutableLiveData<>();
        }
        return isLoadingLivData;
    }

    public LiveData<List<PreviousOrderModel>> onOrderDataSuccess() {
        if (onOrderDataSuccess == null) {
            onOrderDataSuccess = new MutableLiveData<>();
        }
        return onOrderDataSuccess;
    }

    public MutableLiveData<String> getFilterBy() {
        if (filterBy == null) {
            filterBy = new MutableLiveData<>();
        }
        return filterBy;
    }

    public void setFilterBy(String filter){
        getFilterBy().setValue(filter);
    }
    public void getOrder(String user_token, String filterBy) {
        isLoadingLivData.setValue(true);

        Api.getService(Tags.base_url)
                .getPreviousOrders(user_token, filterBy)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<PreviousOrderDataModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull Response<PreviousOrderDataModel> response) {
                        isLoadingLivData.setValue(false);
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getStatus() == 200) {
                                    onOrderDataSuccess.setValue(response.body().getData());
                                }
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        isLoadingLivData.setValue(false);

                        Log.d(TAG, "onError: ", e);
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
