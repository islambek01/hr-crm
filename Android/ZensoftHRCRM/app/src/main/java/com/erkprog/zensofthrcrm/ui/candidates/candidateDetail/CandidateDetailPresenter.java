package com.erkprog.zensofthrcrm.ui.candidates.candidateDetail;

import android.annotation.SuppressLint;
import android.util.Log;

import com.erkprog.zensofthrcrm.data.entity.Candidate;
import com.erkprog.zensofthrcrm.data.network.candidates.CandidatesRepository;

import retrofit2.Response;

public class CandidateDetailPresenter implements CandidateDetailContract.Presenter,
    CandidatesRepository.OnDetailCandidateLoadFinishedListener {

  private static final String TAG = "mylog:CandidateDetailPresente";

  private CandidateDetailContract.View mView;
  private CandidatesRepository mRepository;

  public CandidateDetailPresenter(CandidateDetailContract.View view, CandidatesRepository repository) {
    mView = view;
    mRepository = repository;
  }

  @Override
  public void loadCandidateInfo() {
    mRepository.getDetailCandidateFromJson(this);

  }

  @SuppressLint("LongLogTag")
  @Override
  public void onFinished(Response<Candidate> response) {
    Log.d(TAG, "onFinished: success");
    Candidate candidate = response.body();
    mView.showCandidateDetails(candidate);
  }

  @SuppressLint("LongLogTag")
  @Override
  public void onFailure(Throwable t) {
    Log.d(TAG, "onFailure: starts");

  }
}
