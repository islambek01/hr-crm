package com.erkprog.zensofthrcrm.ui.candidates.candidatesList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Candidate;

import java.util.List;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.CandidateViewHolder> {

  private List<Candidate> mCandidates;
  private Context mContext;
  private OnItemClickListener mlistener;

  public interface OnItemClickListener {
    void onItemClick(int position);
  }

  public void setOnItemClickListener(OnItemClickListener listener) {
    mlistener = listener;
  }

  public CandidatesAdapter(Context context, List<Candidate> candidates) {
    mCandidates = candidates;
    mContext = context;
  }

  @NonNull
  @Override
  public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate_item, parent, false);
    return new CandidateViewHolder(view, mlistener);
  }

  @Override
  public void onBindViewHolder(@NonNull CandidateViewHolder holder, int position) {
    Candidate candidate = mCandidates.get(position);

    holder.firstName.setText(candidate.getFirstName() != null ? candidate.getFirstName() : "");
    holder.lastName.setText(candidate.getLastName() != null ? candidate.getLastName() : "");
    holder.requestName.setText("");
    holder.status.setText(String.valueOf(candidate.getStatus()));

  }

  @Override
  public int getItemCount() {
    return (mCandidates != null ? mCandidates.size() : 0);
  }

  public void loadNewData(List<Candidate> candidates) {
    mCandidates = candidates;
    this.notifyDataSetChanged();
  }

  static class CandidateViewHolder extends RecyclerView.ViewHolder {
    TextView firstName;
    TextView lastName;
    TextView requestName;
    TextView status;

    public CandidateViewHolder(View itemView, final OnItemClickListener listener) {
      super(itemView);

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (listener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
              listener.onItemClick(position);
            }
          }
        }
      });

      firstName = itemView.findViewById(R.id.citem_firstName);
      lastName = itemView.findViewById(R.id.citem_lastName);
      requestName = itemView.findViewById(R.id.citem_request_name);
      status = itemView.findViewById(R.id.citem_status);
    }
  }

}
