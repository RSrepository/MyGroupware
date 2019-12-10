class CreateFacilityUsages < ActiveRecord::Migration[6.0]
  def change
    create_table :facility_usages do |t|
      t.string :user_id
      t.string :facility_id
      t.string :plan_id

      t.timestamps
    end
  end
end
