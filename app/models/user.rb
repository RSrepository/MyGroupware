class User < ApplicationRecord
	enum authority: { general: 0, admin: 1 }
end
