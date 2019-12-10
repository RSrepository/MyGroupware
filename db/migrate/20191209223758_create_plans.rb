class CreatePlans < ActiveRecord::Migration[6.0]
  def change
    create_table :plans do |t|
      t.string :user_id
      t.string :content
      t.datetime :start_time
      t.datetime :end_time
      t.text :remarks

      t.timestamps
    end
  end
end
