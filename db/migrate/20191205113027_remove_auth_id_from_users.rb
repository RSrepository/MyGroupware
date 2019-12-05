class RemoveAuthIdFromUsers < ActiveRecord::Migration[6.0]
  def change

    remove_column :users, :auth_id, :integer
  end
end
