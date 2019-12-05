class CreateAttendances < ActiveRecord::Migration[6.0]
  def change
    create_table :attendances do |t|
      t.string :user_id
      t.datetime :work_start_time
      t.datetime :work_end_time
      t.time :break_time

      t.timestamps
    end
  end
end
