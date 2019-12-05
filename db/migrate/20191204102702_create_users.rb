class CreateUsers < ActiveRecord::Migration[6.0]
  def change
    create_table :users do |t|
      t.string :name
      t.string :password
      t.integer :auth_id
      t.boolean :delete_flag

      t.timestamps
    end
  end
end
