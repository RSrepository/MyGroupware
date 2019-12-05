class CreateEmails < ActiveRecord::Migration[6.0]
  def change
    create_table :emails do |t|
      t.string :sender_user_id
      t.string :receiver
      t.string :title
      t.text :message

      t.timestamps
    end
  end
end
