 public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        ArrayList<String> list;
        Context context;

        public Adapter(ArrayList<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem = layoutInflater.inflate(R.layout.chat_list_recyclerview_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.userNameTitle.setText(list.get(position));
            holder.deleteUserBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            Button deleteUserBtn;
            TextView userNameTitle;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                deleteUserBtn = itemView.findViewById(R.id.deleteUserbtn);
                userNameTitle = itemView.findViewById(R.id.userNameTitle);
            }
        }
    }
